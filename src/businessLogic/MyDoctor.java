package businessLogic;

import xml.MyDoctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * MyDoctor Class
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MyDoctor {

    // Attributes

    @XmlID
    @XmlAttribute
    private String id;

    private String lastName;
    private String firstName;
    private String speciality;
    private String address;

    private int morningStartHour;
    private int morningEndHour;
    private int afternoonStartHour;
    private int afternoonEndHour;
    private int appointmentLast;

    // Constructors

    /**
     * Default constructor
     */
    public MyDoctor() {
        this.id = String.valueOf(MyDoctors.nextID);
        MyDoctors.nextID++;
    }

    /**
     * Constructor with parameters
     *
     * @param lastName           doctor last name
     * @param firstName          doctor first name
     * @param speciality         doctor speciality
     * @param address            doctor address
     * @param morningStartHour   doctor morning start hour
     * @param morningEndHour     doctor morning end hour
     * @param afternoonStartHour doctor afternoon start hour
     * @param afternoonEndHour   doctor afternoon end hour
     * @param appointmentLast    doctor appointment time (generally 30 minutes)
     */
    public MyDoctor(String lastName, String firstName, String speciality, String address, int morningStartHour, int morningEndHour, int afternoonStartHour, int afternoonEndHour, int appointmentLast) {
        this.id = String.valueOf(MyDoctors.nextID);
        MyDoctors.nextID++;

        this.lastName = lastName;
        this.firstName = firstName;
        this.speciality = speciality;
        this.address = address;
        this.morningStartHour = morningStartHour;
        this.morningEndHour = morningEndHour;
        this.afternoonStartHour = afternoonStartHour;
        this.afternoonEndHour = afternoonEndHour;
        this.appointmentLast = appointmentLast;
    }

    /**
     * Get doctor id
     *
     * @return doctor id
     */
    public String getId() {
        return id;
    }

    /**
     * Set doctor id
     *
     * @param id (int)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get doctor last name
     *
     * @return doctor last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get doctor first name
     *
     * @return doctor first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get doctor speciality
     *
     * @return doctor speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Get doctor address
     *
     * @return doctor address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get doctor morning start hour
     *
     * @return doctor morning start hour
     */
    public int getMorningStartHour() {
        return morningStartHour;
    }

    /**
     * Get doctor morning end hour
     *
     * @return doctor morning end hour
     */
    public int getMorningEndHour() {
        return morningEndHour;
    }

    /**
     * Get doctor afternoon start hour
     *
     * @return doctor afternoon start hour
     */
    public int getAfternoonStartHour() {
        return afternoonStartHour;
    }

    /**
     * Get doctor afternoon end hour
     *
     * @return doctor afternoon end hour
     */
    public int getAfternoonEndHour() {
        return afternoonEndHour;
    }

    /**
     * Get doctor appointment last
     *
     * @return doctor appointment last
     */
    public int getAppointmentLast() {
        return appointmentLast;
    }

    /**
     * transform doctor information to string
     *
     * @return information for doctor
     */
    @Override
    public String toString() {
        return "MyDoctor{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", address='" + address + '\'' +
                ", morningStartHour=" + morningStartHour +
                ", morningEndHour=" + morningEndHour +
                ", afternoonStartHour=" + afternoonStartHour +
                ", afternoonEndHour=" + afternoonEndHour +
                ", appointmentLast=" + appointmentLast +
                '}';
    }

    /**
     * Get work schedule for a doctor month of work
     *
     * @param year  (int)
     * @param month (int)
     * @return all schedules for a doctor month of work
     */
    public ArrayList<String> getWorkSchedules(int year, int month) {
        int nbHours = (this.morningEndHour - this.morningStartHour) + (this.afternoonEndHour - this.afternoonStartHour);
        int nbAppointment = (nbHours * 60) / this.appointmentLast;

        ArrayList<String> scheduleArrayList = new ArrayList<>();
        LocalDateTime lastAppointment = null;
        LocalDate start = LocalDate.of(year, month, 1);

        while (!start.isEqual(LocalDate.of(year, month, start.lengthOfMonth()))) {
            if (!start.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !start.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                for (int i = 0; i < nbAppointment; i++) {
                    if (i == 0) {
                        lastAppointment = LocalDateTime.of(year, month, start.getDayOfMonth(), this.morningStartHour, 0);
                        scheduleArrayList.add(lastAppointment.toString());
                    } else {
                        if (lastAppointment.plusMinutes(this.appointmentLast).isBefore(LocalDateTime.of(year, month, 1, this.morningEndHour, 0))) {
                            lastAppointment = lastAppointment.plusMinutes(this.appointmentLast);
                            scheduleArrayList.add(lastAppointment.toString());

                        } else {
                            if (lastAppointment.isBefore(LocalDateTime.of(year, month, start.getDayOfMonth(), this.afternoonStartHour, 0))) {
                                lastAppointment = LocalDateTime.of(year, month, start.getDayOfMonth(), this.afternoonStartHour, 0);
                                scheduleArrayList.add(lastAppointment.toString());
                            } else {
                                lastAppointment = lastAppointment.plusMinutes(this.appointmentLast);
                                scheduleArrayList.add(lastAppointment.toString());
                            }

                        }
                    }
                }
            }

            start = start.plusDays(1);
        }

        return scheduleArrayList;
    }
}
