package businessLogic;

/**
 * This class represents a doctor and all his information
 */
public class Doctor {

    // Attributes

    private String lastName;
    private String firstName;
    private String speciality; // Principe d'amélioration : Créer un enum avec une liste de spécialité
    private String address;


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
    public Doctor(String lastName, String firstName, String speciality, String address) {
        try {
            if (Utility.nameValidated(firstName, lastName)) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.speciality = speciality;
                this.address = address;
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
}
