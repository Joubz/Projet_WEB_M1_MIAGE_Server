package businessLogic;

/**
 * 1/ Doctor (Get)
 * 2/ Schedule (Get by Doctor) retourne au mois
 */


import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents a doctor and all his information
 */
@XmlRootElement
public class Doctor {

    // Attributes

    private String lastName;
    private String firstName;
    private String speciality;
    private String address;
    private int morningStartHour;
    private int morningEndHour;
    private int afternoonStartHour;
    private int afternoonEndHour;
    private int appointmentLast;

    // Constructor

    /**
     * default constructor
     */
    public Doctor() {

    }

    /**
     * Constructor with parameters of main.Doctor class
     *
     * @param lastName   main.Doctor last name
     * @param firstName  main.Doctor first name
     * @param speciality main.Doctor speciality
     * @param address    main.Doctor address
     */
    public Doctor(String lastName, String firstName, String speciality, String address, int morningStartHour, int morningEndHour, int afternoonStartHour, int afternoonEndHour, int appointmentLast) {
        try {
            if (Utility.nameValidated(firstName, lastName)) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.speciality = speciality;
                this.address = address;
                this.morningStartHour = morningStartHour;
                this.morningEndHour = morningEndHour;
                this.afternoonStartHour = afternoonStartHour;
                this.afternoonEndHour = afternoonEndHour;
                this.appointmentLast = appointmentLast;

            } else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            Log.WriteMessage(e);
        }

    }

    /**
     * Get the last name of the doctor
     *
     * @return the last name of the doctor
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get the doctor first name
     *
     * @return the doctor first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get the doctor speciality
     *
     * @return the doctor speciality
     */
    public String getSpeciality() {
        return this.speciality;
    }

    /**
     * Get the doctor adress
     *
     * @return the doctor adress
     */
    public String getAddress() {
        return this.address;
    }

    public int getMorningStartHour() {
        return morningStartHour;
    }

    public int getMorningEndHour() {
        return morningEndHour;
    }

    public int getAfternoonStartHour() {
        return afternoonStartHour;
    }

    public int getAfternoonEndHour() {
        return afternoonEndHour;
    }

    public int getAppointmentLast() {
        return appointmentLast;
    }
}
