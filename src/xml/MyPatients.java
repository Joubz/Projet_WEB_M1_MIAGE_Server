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


/**
 * MyPatients class
 */
@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyPatients {
    public static final String FILE_NAME = "patients.xml";

    public static int nextID = 0;

    @XmlAttribute(name = "nextID")
    public int attrNextId = 0;

    @XmlElement(name = "patient", type = MyPatient.class)
    private List<MyPatient> patients = new ArrayList<>();

    /**
     * Get patients
     *
     * @return patients
     */
    public List<MyPatient> getPatients() {
        return patients;
    }

    /**
     * Put patients information to string
     *
     * @return patient information string
     */
    @Override
    public String toString() {
        return "MyPatients{" +
                "patients=" + patients +
                '}';
    }

    /**
     * Add a patient to patient list
     *
     * @param patient patient that we want to add on a list
     */
    public void add(MyPatient patient) {
        MyPatients.assignId(patient);
        this.patients.add(patient);
    }

    /**
     * Encore patient list to an xml file
     */
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
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decode patient xml file to create patient list
     */
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

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * Assign an id for new patient
     *
     * @param patient (MyPatient)
     */
    public static void assignId(MyPatient patient) {
        MyPatients manager = new MyPatients();
        manager.decode();
        patient.setId(MyPatients.nextID);
        MyPatients.nextID++;
        manager.getPatients().clear();
        manager.encode();
    }

}
