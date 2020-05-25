package test;

import businessLogic.Appointment;
import businessLogic.Doctor;
import businessLogic.Patient;
import org.junit.Assert;
import org.junit.Test;


/**
 * Class where we test all class implementations
 */
public class ClassImplTest {

    @Test
    public final void testPatientClassImpl() {
        Patient patient = new Patient("Julien", "Bascou", "20/09/1998",
                'M', 68, 174, "0611026088", "bascou@gmail.com");

        Assert.assertEquals("Julien", patient.getFirstName());
        Assert.assertEquals("Bascou", patient.getLastName());
        Assert.assertEquals("20/09/1998", patient.getDateOfBirth());
        Assert.assertEquals('M', patient.getGender());
        Assert.assertEquals(68, patient.getWeight());
        Assert.assertEquals(174, patient.getHeight());
        Assert.assertEquals("0611026088", patient.getPhone());
        Assert.assertEquals("bascou@gmail.com", patient.getEmail());

    }

    /*
    @Test
    public final void testDoctorClassImpl() {
        Doctor doctor = new Doctor("Bascou", "Julien", "Généraliste",
                "1 rue du paradis");

        Assert.assertEquals("Julien", doctor.getFirstName());
        Assert.assertEquals("Bascou", doctor.getLastName());
        Assert.assertEquals("Généraliste", doctor.getSpeciality());
        Assert.assertEquals("1 rue du paradis", doctor.getAddress());
    }

    @Test
    public final void testAppointmentClassImpl() {
        Patient patient = new Patient("Julien", "Bascou", "20/09/1998",
                'M', 68, 174, "0611026088", "bascou@gmail.com");
        Doctor doctor = new Doctor("Bascou", "Julien", "Généraliste",
                "1 rue du paradis");

        Appointment appointment = new Appointment(doctor, patient, "20/09/2020", "17-17h30");

        Assert.assertEquals(doctor, appointment.getDoctor());
        Assert.assertEquals(patient, appointment.getPatient());
        Assert.assertEquals("20/09/2020", appointment.getDate());
        Assert.assertEquals("17-17h30", appointment.getTime());

    }*/


}
