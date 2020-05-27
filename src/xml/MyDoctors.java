package xml;

import businessLogic.MyDoctor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "doctors")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyDoctors {
    public static final String FILE_NAME = "doctors.xml";

    public static int nextID = 0;

    @XmlAttribute(name = "nextID")
    public int attrNextId = 0;

    @XmlElement(name = "doctor", type = MyDoctor.class)
    private List<MyDoctor> doctors = new ArrayList<>();

    public List<MyDoctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return "MyDoctors{" +
                "attrNextId=" + attrNextId +
                ", doctors=" + doctors +
                '}';
    }

    public void add(MyDoctor doctor) {
        this.doctors.add(doctor);
    }

    public void encode() {
        this.attrNextId = MyDoctors.nextID;

        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(MyDoctors.class);

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
            this.attrNextId = MyDoctors.nextID = 0;
        } else {
            JAXBContext jaxbContext;

            try {
                jaxbContext = JAXBContext.newInstance(MyDoctors.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                MyDoctors object = (MyDoctors) jaxbUnmarshaller.unmarshal(xmlFile);

                this.doctors = object.doctors;
                this.attrNextId = object.attrNextId;
                MyDoctors.nextID = object.attrNextId;

            }
            catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }


    }

}
