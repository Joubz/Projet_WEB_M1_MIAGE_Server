package businessLogic;

/**
 * 1/ Doctor (Get)
 * 2/ Schedule (Get by Doctor) retourne au mois
 */


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents a doctor and all his information
 */
@Root(name = "doctor")
public class Doctor {

    // Attributes

    @Attribute(name = "id")
    private int id;
    @Element(name = "lastName")
    private String lastName;
    @Element(name = "firstName")
    private String firstName;
    @Element(name = "speciality")
    private String speciality;
    @Element(name = "address")
    private String address;
    @Element(name = "morningStartHour")
    private int morningStartHour;
    @Element(name = "morningEndHour")
    private int morningEndHour;
    @Element(name = "afternoonStartHour")
    private int afternoonStartHour;
    @Element(name = "afternoonEndHour")
    private int afternoonEndHour;
    @Element(name = "appointmentLast")
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

    /**
     * Get the doctor morning start hour
     *
     * @return the doctor morning start hour
     */
    public int getMorningStartHour() {
        return morningStartHour;
    }

    /**
     * Get the doctor morning end hour
     *
     * @return the doctor end hour
     */
    public int getMorningEndHour() {
        return morningEndHour;
    }

    /**
     * Get the doctor afternoon start hour
     *
     * @return the doctor afternoon start hour
     */
    public int getAfternoonStartHour() {
        return afternoonStartHour;
    }

    /**
     * Get the doctor afternoon end hour
     *
     * @return the doctor afternoon end hour
     */
    public int getAfternoonEndHour() {
        return afternoonEndHour;
    }

    /**
     * Get the doctor appointment time
     *
     * @return the doctor appointment time (generally = 20 minutes)
     */
    public int getAppointmentLast() {
        return appointmentLast;
    }


    /**
     * Get doctor id
     *
     * @return doctor id
     */
    public int getId() {
        return id;
    }

    /**
     * Set doctor id
     *
     * @param id doctor id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter the doctor last name
     *
     * @param lastName (String)
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the doctor first name
     *
     * @param firstName (String)
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the doctor speciality
     *
     * @param speciality (String)
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * Set the doctor Address
     *
     * @param address (String)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the doctor morning start hour
     *
     * @param morningStartHour (int)
     */
    public void setMorningStartHour(int morningStartHour) {
        this.morningStartHour = morningStartHour;
    }

    /**
     * Set the doctor morning end hour
     *
     * @param morningEndHour (int)
     */
    public void setMorningEndHour(int morningEndHour) {
        this.morningEndHour = morningEndHour;
    }

    /**
     * Set the doctor afternoon start hour
     *
     * @param afternoonStartHour (int)
     */
    public void setAfternoonStartHour(int afternoonStartHour) {
        this.afternoonStartHour = afternoonStartHour;
    }

    /**
     * Set the doctor afternoon end hour
     *
     * @param afternoonEndHour (int)
     */
    public void setAfternoonEndHour(int afternoonEndHour) {
        this.afternoonEndHour = afternoonEndHour;
    }

    /**
     * Set the appointment last
     *
     * @param appointmentLast (int)
     */
    public void setAppointmentLast(int appointmentLast) {
        this.appointmentLast = appointmentLast;
    }


}
