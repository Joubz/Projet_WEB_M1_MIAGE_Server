package businessLogic;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import xml.MyDoctorAdapter;
import xml.MyDoctorDeserializer;
import xml.MyPatientAdapter;
import xml.MyPatientDeserializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class MyAppointment {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlAttribute
    @XmlJavaTypeAdapter(MyDoctorAdapter.class)
    @JsonDeserialize(using = MyDoctorDeserializer.class)
    private MyDoctor doctor;

    @XmlAttribute
    @XmlJavaTypeAdapter(MyPatientAdapter.class)
    @JsonDeserialize(using = MyPatientDeserializer.class)
    private MyPatient patient;

    private String date;

    private String time;

    public MyAppointment() {
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public MyDoctor getDoctor() {
        return doctor;
    }

    public MyPatient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

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