package businessLogic;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * This class represents a patient and all his information
 */
@Root(name = "patient")
public class Patient {

    // Attributes

    @Attribute(name = "id")
    private int id;
    @Element(name = "firstName")
    private String firstName;
    @Element(name = "lastName")
    private String lastName;
    @Element(name = "phone")
    private String phone;
    @Element(name = "email")
    private String email;
    @Element(name = "dateOfBirth")
    private String dateOfBirth;
    @Element(name = "gender")
    private char gender;
    @Element(name = "weight")
    private int weight;
    @Element(name = "height")
    private int height;


    // Constructors

    /**
     * Constructor by default of main.Patient class
     */
    public Patient() {
    }

    /**
     * @param firstName   main.Patient first name
     * @param lastName    main.Patient last name
     * @param dateOfBirth main.Patient date of birth
     * @param gender      main.Patient gender (F or M)
     * @param weight      main.Patient weight (in kg unit)
     * @param height      main.Patient height (in cm unit)
     * @param phone       main.Patient phone number
     * @param email       main.Patient email
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

    /**
     * Get patient id
     *
     * @return patient id
     */
    public int getId() {
        return id;
    }

    /**
     * Set patient id
     *
     * @param id patient id (int)
     */
    public void setId(int id) {
        this.id = id;
    }
}
