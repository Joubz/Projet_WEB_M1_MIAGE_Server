package xml;

import businessLogic.MyAppointment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Appointments xml class
 */
@XmlRootElement(name = "appointments")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyAppointments {

    // Attributes

    public static final String FILE_NAME = "appointments.xml";

    public static int nextID = 0;

    @XmlAttribute(name = "nextID")
    public int attrNextId = 0;

    @XmlElement(name = "appointment", type = MyAppointment.class)
    private List<MyAppointment> appointments = new ArrayList<>();

    // Methods

    /**
     * Get appointments
     *
     * @return appointments
     */
    public List<MyAppointment> getAppointments() {
        return appointments;
    }

    /**
     * Put appointments information to string
     *
     * @return appointments information string
     */
    @Override
    public String toString() {
        return "MyAppointments{" +
                "attrNextId=" + attrNextId +
                ", patients=" + appointments +
                '}';
    }

    /**
     * Add an appointment to appointment list
     *
     * @param appointment appointment that we want to add on a list
     */
    public void add(MyAppointment appointment) {
        MyAppointments.assignId(appointment);
        this.appointments.add(appointment);
    }

    /**
     * Encode appointment list to an xml file
     */
    public void encode() {
        this.attrNextId = MyAppointments.nextID;

        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(MyAppointments.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setAdapter(MyDoctorAdapter.class, new MyDoctorAdapter());
            jaxbMarshaller.setAdapter(MyPatientAdapter.class, new MyPatientAdapter());

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
     * Decode appointment xml file to create appointment list
     */
    public void decode() {
        File xmlFile = new File(FILE_NAME);

        if (!xmlFile.exists()) {
            this.attrNextId = MyAppointments.nextID = 0;
        } else {
            JAXBContext jaxbContext;

            try {
                jaxbContext = JAXBContext.newInstance(MyAppointments.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                jaxbUnmarshaller.setAdapter(MyDoctorAdapter.class, new MyDoctorAdapter());
                jaxbUnmarshaller.setAdapter(MyPatientAdapter.class, new MyPatientAdapter());

                MyAppointments object = (MyAppointments) jaxbUnmarshaller.unmarshal(xmlFile);

                this.appointments = object.appointments;
                this.attrNextId = object.attrNextId;
                MyAppointments.nextID = object.attrNextId;

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Assign an id for new appointment
     *
     * @param appointment (MyAppointment)
     */
    public static void assignId(MyAppointment appointment) {
        MyAppointments manager = new MyAppointments();
        manager.decode();
        appointment.setId(MyAppointments.nextID);
        MyAppointments.nextID++;
        manager.encode();
    }

}
