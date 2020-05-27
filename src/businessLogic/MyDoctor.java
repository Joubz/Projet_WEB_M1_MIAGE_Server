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

@XmlAccessorType(XmlAccessType.FIELD)
public class MyDoctor {

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

    public MyDoctor() {
        this.id = String.valueOf(MyDoctors.nextID);
        MyDoctors.nextID++;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getAddress() {
        return address;
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
