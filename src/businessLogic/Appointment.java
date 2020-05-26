package businessLogic;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.ws.rs.ext.Provider;

@Root(name = "appointment")
public class Appointment {

    // Attributes
    @Attribute(name = "id")
    private int id;
    @Element(name = "doctor")
    private int doctorId;
    @Element(name = "patient")
    private int patientId;
    @Element(name = "date")
    private String date;
    @Element(name = "time")
    private String time;

    private Doctor doctor;
    private Patient patient;

    // Constructors

    /**
     * default constructor
     */
    public Appointment() {
    }

    /**
     * Constructor with parameters of main.Appointment class
     *
     * @param doctor  for the appointment
     * @param patient for the appointment
     * @param date    appointment date
     * @param time    appointment time
     */
    public Appointment(Doctor doctor, Patient patient, String date, String time) {
        try {
            if (Utility.dateValidated(date)) {
                this.doctor = doctor;
                this.patient = patient;
                this.date = date;
                this.time = time;
            } else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            Log.WriteMessage(e);
        }
    }

    /**
     * Get the doctor for the current appointment
     *
     * @return the doctor for the current appointment
     */
    public Doctor getDoctor() {
        return this.doctor;
    }

    /**
     * Get the patient for the current appointment
     *
     * @return the patient for the current appointment
     */
    public Patient getPatient() {
        return this.patient;
    }

    /**
     * Get the appointment date
     *
     * @return the appointment date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Get the appointment time
     *
     * @return the appointment time
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Get appointment id
     *
     * @return appointment id
     */
    public int getId() {
        return id;
    }

    /**
     * Get doctor id for the appointment
     *
     * @return doctor id for the appointment
     */
    public int getDoctorId() {
        return doctorId;
    }

    /**
     * Get patient id for the appointment
     *
     * @return patient id for the appoint
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Set appointment id
     *
     * @param id appointment id (int)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set doctor id for appointment
     *
     * @param doctorId doctor id for appointment (int)
     */
    public void setIdDoctor(int doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * Set patient id for appointment
     *
     * @param patientId
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Set doctor for appointment
     *
     * @param doctor (Doctor)
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Set patient for appointment
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Set date for appointment
     *
     * @param date appointment date (String)
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Set time for appointment
     *
     * @param time appointment date (String)
     */
    public void setTime(String time) {
        this.time = time;
    }
}
