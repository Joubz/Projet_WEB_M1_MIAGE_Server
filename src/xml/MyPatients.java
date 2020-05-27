package xml;

import businessLogic.MyPatient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

;

@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyPatients {
    public static final String FILE_NAME = "patients.xml";

    public static int nextID = 0;

    @XmlAttribute(name = "nextID")
    public int attrNextId = 0;

    @XmlElement(name = "patient", type = MyPatient.class)
    private List<MyPatient> patients = new ArrayList<>();

    public List<MyPatient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "MyPatients{" +
                "patients=" + patients +
                '}';
    }

    public void add(MyPatient patient) {
        MyPatients.assignId(patient);
        this.patients.add(patient);
    }

    public void encode() {
        this.attrNextId = MyPatients.nextID;

        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(MyPatients.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File(FILE_NAME);

            //Writes XML file to file-system
            jaxbMarshaller.marshal(this, file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void decode() {
        File xmlFile = new File(FILE_NAME);

        if (!xmlFile.exists()) {
            this.attrNextId = MyPatients.nextID = 0;
        } else {
            JAXBContext jaxbContext;

            try {
                jaxbContext = JAXBContext.newInstance(MyPatients.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                MyPatients object = (MyPatients) jaxbUnmarshaller.unmarshal(xmlFile);

                this.patients = object.patients;
                this.attrNextId = object.attrNextId;
                MyPatients.nextID = object.attrNextId;

            }
            catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }


    }

    public static void assignId(MyPatient patient) {
        MyPatients manager = new MyPatients();
        manager.decode();
        patient.setId(MyPatients.nextID);
        MyPatients.nextID++;
        manager.getPatients().clear();
        manager.encode();
    }

}
