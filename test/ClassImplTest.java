import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class where we test all class implementations
 */
public class ClassImplTest {

    @Test
    public final void testPatientClassImpl() {
        Patient patient = new Patient("Julien", "Bascou", "20/09/1998",
                'M', 68, 174, "0611026088", "bascou@gmail.com");

        assertEquals("Julien", patient.getFirstName());
        assertEquals("Bascou", patient.getLastName());
        assertEquals("20/09/1998", patient.getDateOfBirth());
        assertEquals('M', patient.getGender());
        assertEquals(68, patient.getWeight());
        assertEquals(174, patient.getHeight());
        assertEquals("0611026088", patient.getPhone());
        assertEquals("bascou@gmail.com", patient.getEmail());

    }

    @Test
    public final void testDoctorClassImpl() {
        Doctor doctor = new Doctor("Bascou", "Julien", "Généraliste",
                "1 rue du paradis");

        assertEquals("Julien", doctor.getFirstName());
        assertEquals("Bascou", doctor.getLastName());
        assertEquals("Généraliste", doctor.getSpeciality());
        assertEquals("1 rue du paradis", doctor.getAddress());
    }

    @Test
    public final void testAppointmentClassImpl() {
        Patient patient = new Patient("Julien", "Bascou", "20/09/1998",
                'M', 68, 174, "0611026088", "bascou@gmail.com");
        Doctor doctor = new Doctor("Bascou", "Julien", "Généraliste",
                "1 rue du paradis");

        Appointment appointment = new Appointment(doctor, patient, "20/09/2020", "17-17h30");

        assertEquals(doctor, appointment.getDoctor());
        assertEquals(patient, appointment.getPatient());
        assertEquals("20/09/2020", appointment.getDate());
        assertEquals("17-17h30", appointment.getTime());

    }


}
