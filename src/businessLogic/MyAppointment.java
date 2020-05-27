package businessLogic;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import xml.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * MyAppointment class
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MyAppointment {

    // Attributes

    @XmlID
    @XmlAttribute
    private String id;

    @XmlAttribute
    @XmlJavaTypeAdapter(MyDoctorAdapter.class)
    @JsonDeserialize(using = MyDoctorDeserializer.class)
    @JsonSerialize(using = MyDoctorSerializer.class)
    private MyDoctor doctor;

    @XmlAttribute
    @XmlJavaTypeAdapter(MyPatientAdapter.class)
    @JsonDeserialize(using = MyPatientDeserializer.class)
    @JsonSerialize(using = MyPatientSerializer.class)
    private MyPatient patient;

    private String date;

    private String time;


    // Constructor

    /**
     * Default constructor for MyAppointment class
     */
    public MyAppointment() {
    }

    // Methods

    /**
     * Get appointment id
     *
     * @return appointment id
     */
    public String getId() {
        return id;
    }

    /**
     * Set appointment id
     *
     * @param id (int)
     */
    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    /**
     * Get doctor information
     *
     * @return doctor information
     */
    public MyDoctor getDoctor() {
        return doctor;
    }

    /**
     * Get patient information
     *
     * @return partient information
     */
    public MyPatient getPatient() {
        return patient;
    }

    /**
     * Get appointment date
     *
     * @return appointment date
     */
    public String getDate() {
        return date;
    }

    /**
     * Get appointment time
     *
     * @return appointment time
     */
    public String getTime() {
        return time;
    }

    /**
     * transform appointment information to string
     *
     * @return information for appointment
     */
    @Override
    public String toString() {
        return "MyAppointment{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}