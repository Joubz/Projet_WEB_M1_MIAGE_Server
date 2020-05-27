package main;

import businessLogic.MyAppointment;
import businessLogic.MyDoctor;
import xml.MyAppointments;
import xml.MyDoctors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;


@Path("/Schedules")
public class ScheduleService {

    @GET
    @Path("/{doctorId}/{month}/{year}")
    @Produces("application/json")
    public Response getSchedule(@PathParam("doctorId") String doctorId, @PathParam("month") String month, @PathParam("year") String year) {
        try {
            MyDoctors docManager = new MyDoctors();
            docManager.decode();

            MyDoctor doctor = null;

            boolean found = false;
            Iterator<MyDoctor> itDoctor = docManager.getDoctors().iterator();
            while (!found && itDoctor.hasNext()) {
                MyDoctor d = itDoctor.next();
                if (d.getId().equals(doctorId)) {
                    doctor = d;
                    found = true;
                }
            }

            if (!found) {
                return Response.status(Response.Status.NOT_FOUND)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .build();
            }

            if (Integer.parseInt(month) > 12) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .build();
            }

            MyAppointments appointmentsManager = new MyAppointments();
            appointmentsManager.decode();

            ArrayList<MyAppointment> list = new ArrayList<>();

            for (MyAppointment appointment: appointmentsManager.getAppointments()) {
                if (appointment.getDoctor().getId().equals(doctorId)) {
                    String[] splited = appointment.getDate().split("-");
                    if (Integer.parseInt(appointment.getDate().substring(5, 7)) == Integer.parseInt(month)) {
                        if (Integer.parseInt(appointment.getDate().substring(0, 4)) == Integer.parseInt(year)) {
                            list.add(appointment);
                        }
                    }
                }
            }

            ArrayList<String> freeSchedules = doctor.getWorkSchedules(Integer.parseInt(year), Integer.parseInt(month));
            ArrayList<String> scheduleToDelete = new ArrayList<>();

            for (String free: freeSchedules) {
                for (MyAppointment appointment: list) {
                    if (free.equals(appointment.getDate() + 'T' + appointment.getTime())) {
                        scheduleToDelete.add(free);
                    }
                }
            }

            System.out.println(scheduleToDelete);
            freeSchedules.removeAll(scheduleToDelete);

            return Response.ok().entity(freeSchedules)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .build();
        }


    }

}
