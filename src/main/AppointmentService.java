package main;

import businessLogic.MyAppointment;
import businessLogic.MyDoctor;
import xml.MyAppointments;
import xml.MyDoctors;
import xml.MyPatients;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;

@Path("/Appointments")
public class AppointmentService {

    private MyAppointments myAppointments = new MyAppointments();
    private MyPatients myPatients;

    public AppointmentService() {
        myAppointments.decode();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointments() {
        System.out.println(myAppointments.getAppointments());

        return Response.ok().entity(myAppointments.getAppointments())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getAppointment(@PathParam("id") String id) throws Exception {
        System.out.println(id);
        for (MyAppointment appointment: this.myAppointments.getAppointments()) {
            if (appointment.getId().equals(id)) {
                return Response.ok().entity(appointment)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

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

            return Response.ok().entity(list)
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


    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAppointment(final MyAppointment myAppointment) {
        System.out.println(myAppointment);

        // Enregistrement du patient
        this.myPatients = new MyPatients();
        myPatients.decode();
        myPatients.add(myAppointment.getPatient());
        myPatients.encode();

        // Enregistrement du rendez-vous
        myAppointments.decode();
        myAppointments.add(myAppointment);
        myAppointments.encode();

        return Response.ok().entity(myAppointment)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    @OPTIONS
    public Response optionsAppointments() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }


    @DELETE
    @Path("/{appointmentId}")
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAppointment(@PathParam("appointmentId") String appointmentId) {
        for (MyAppointment appointment: this.myAppointments.getAppointments()) {
            if (appointment.getId().equals(appointmentId)) {
                this.myAppointments.getAppointments().remove(appointment);

                this.myAppointments.encode();

                return Response.ok()
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","Content-Type, Accept, X-Requested-With")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    // TODO: PUT

}
