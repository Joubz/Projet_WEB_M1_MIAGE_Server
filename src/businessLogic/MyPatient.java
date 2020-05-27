package businessLogic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;

/**
 * My patient class
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MyPatient {

    // Attributes

    @XmlID
    @XmlAttribute
    private String id;

    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String dateOfBirth;

    private char gender;

    private int height;
    private int weight;


    // Constructors

    /**
     * Default constructor
     */
    public MyPatient() {
    }

    /**
     * Constructor with parameters
     *
     * @param lastName    patient last name
     * @param firstName   patient first name
     * @param phone       patient phone
     * @param email       patient email
     * @param dateOfBirth patient date of birth
     * @param gender      patient gender
     * @param height      patient height
     * @param weight      patient weight
     */
    public MyPatient(String lastName, String firstName, String phone, String email, String dateOfBirth, char gender, int height, int weight) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Get patient id
     *
     * @return patient id
     */
    public String getId() {
        return id;
    }

    /**
     * Set patient id
     *
     * @param id (int)
     */
    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    /**
     * Get patient last name
     *
     * @return patient last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get patient first name
     *
     * @return patient first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get patient phone
     *
     * @return patient phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get patient email
     *
     * @return patient email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get patient date of birth
     *
     * @return patient date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Get patient gender
     *
     * @return patient gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * Get patient height
     *
     * @return patient height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get patient weight
     *
     * @return patient height
     */
    public int getWeight() {
        return weight;
    }

    /**
     * transform patient information to string
     *
     * @return information for patient
     */
    @Override
    public String toString() {
        return "MyPatient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
