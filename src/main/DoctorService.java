package main;

import businessLogic.Appointment;
import businessLogic.Doctor;
import businessLogic.Patient;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Path("/Doctors")
public class DoctorService {

    @GET
    @Produces("application/json")
    public Doctor getDoctor() {
        // TODO:
        return new Doctor("Bascou", "Julien", "Généraliste",
                "1 rue du paradis", 8,
                12, 14, 17, 30);


    }

    // Id du docteur
    // mois
    // année
    @GET
    @Path("/Schedules/{id}/{month}/{year}")
    @Produces("application/json")
    public Response getSchedule(@PathParam("id") int id, @PathParam("month") int month, @PathParam("year") int year) {
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
                        if (lastAppointment != null) {
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
            }

            start = start.plusDays(1);
        }

        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(scheduleArrayList) {
        };
        return Response.ok(entity).build();

    }


}
