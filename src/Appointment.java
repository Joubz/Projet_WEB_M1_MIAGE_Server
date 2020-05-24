public class Appointment {

    // Attributes

    private Doctor doctor;
    private Patient patient;
    private String date;
    private String time;

    // Constructors

    /**
     * default constructor
     */
    public Appointment() {
    }

    /**
     * Constructor with parameters of Appointment class
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

}
