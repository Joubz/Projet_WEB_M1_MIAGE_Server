/**
 * This class represents a patient and all his information
 */
public class Patient {

    // Attributes

    // TODO: Mettre en place un système d'id avec les xml
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String dateOfBirth;
    private char gender;
    private int weight;
    private int height;


    // Constructors

    /**
     * Constructor by default of Patient class
     */
    public Patient() {
    }

    /**
     * @param firstName   Patient first name
     * @param lastName    Patient last name
     * @param dateOfBirth Patient date of birth
     * @param gender      Patient gender (F or M)
     * @param weight      Patient weight (in kg unit)
     * @param height      Patient height (in cm unit)
     * @param phone       Patient phone number
     * @param email       Patient email
     */
    public Patient(String firstName, String lastName, String dateOfBirth, char gender, int weight, int height,
                   String phone, String email) {
        try {
            if (Utility.nameValidated(firstName, lastName) && Utility.phoneValidated(phone) &&
                    Utility.emailValidated(email) && Utility.dateValidated(dateOfBirth)) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.phone = phone;
                this.email = email;
                this.dateOfBirth = dateOfBirth;
                this.gender = gender;
                this.weight = weight;
                this.height = height;
            } else
                throw new Exception(new IllegalArgumentException());

        } catch (Exception e) {
            Log.WriteMessage(e);
        }
    }

    /**
     * Get the patient first name
     *
     * @return the patient first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get the patient last name
     *
     * @return the patient last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get the patient phone
     *
     * @return the patient phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Get the patient email
     *
     * @return the patient email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Get the patient date of birth
     *
     * @return the patient date of birth
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Get the patient gender (F = female, M = Male)
     *
     * @return the patient gender (F = female, M = Male)
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * Get the patient weight (unit = kg)
     *
     * @return the weight of the patient
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Get the patient height (unit = cm)
     *
     * @return the height of the patient
     */
    public int getHeight() {
        return this.height;
    }

}
