package main;

import businessLogic.Appointment;
import businessLogic.Doctor;
import businessLogic.Doctors;
import businessLogic.Patient;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Path("/Doctors")
public class DoctorService {

    @GET
    @Produces("application/json")
    public Response getDoctors() throws Exception {
        try {
            XML xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\doctor.xml"));
            String xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<","<");

            Serializer serializer = new Persister();
            Doctors doctors = serializer.read(Doctors.class, xmlString);
            return Response.ok().entity(doctors)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }


    /**
     * @param id
     * @param month
     * @param year
     * @return
     */
    @GET
    @Path("/Schedules/{id}/{month}/{year}")
    @Produces("application/json")
    public Response getSchedule(@PathParam("id") int id, @PathParam("month") int month, @PathParam("year") int year) {
        // Récuperer l'id du doctor


        Doctor doctor = new Doctor("Bascou", "Julien", "Généraliste",
                "1 rue du paradis", 8,
                12, 14, 17, 30);

        Patient patient = new Patient("Julien", "Bascou", "20/09/1998",
                'M', 68, 174, "0611026088", "bascou@gmail.com");


        Appointment appointment = new Appointment(doctor, patient, "2020/01/01", "9:30");

        int nbHours = (doctor.getMorningEndHour() - doctor.getMorningStartHour()) +
                (doctor.getAfternoonEndHour() - doctor.getAfternoonStartHour());

        int nbAppointment = (nbHours * 60) / doctor.getAppointmentLast();

        ArrayList<String> scheduleArrayList = new ArrayList<>();
        LocalDateTime lastAppointment = null;
        LocalDate start = LocalDate.of(year, month, 1);
        while (!start.isEqual(LocalDate.of(year, month, start.lengthOfMonth()))) {
            if (!start.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !start.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                for (int i = 0; i < nbAppointment; i++) {
                    if (i == 0) {
                        lastAppointment = LocalDateTime.of(year, month, start.getDayOfMonth(), doctor.getMorningStartHour(), 0);
                        scheduleArrayList.add(lastAppointment.toString());
                    } else {
                        if (lastAppointment.plusMinutes(doctor.getAppointmentLast()).isBefore(LocalDateTime.of(year, month, 1, doctor.getMorningEndHour(), 0))) {
                            lastAppointment = lastAppointment.plusMinutes(doctor.getAppointmentLast());
                            scheduleArrayList.add(lastAppointment.toString());

                        } else {
                            if (lastAppointment.isBefore(LocalDateTime.of(year, month, start.getDayOfMonth(), doctor.getAfternoonStartHour(), 0))) {
                                lastAppointment = LocalDateTime.of(year, month, start.getDayOfMonth(), doctor.getAfternoonStartHour(), 0);
                                scheduleArrayList.add(lastAppointment.toString());
                            } else {
                                lastAppointment = lastAppointment.plusMinutes(doctor.getAppointmentLast());
                                scheduleArrayList.add(lastAppointment.toString());
                            }

                        }
                    }
                }
            }

            start = start.plusDays(1);
        }

        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(scheduleArrayList) {
        };
        return Response.ok().entity(entity)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();

    }


}
