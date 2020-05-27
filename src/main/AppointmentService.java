package main;

import businessLogic.MyAppointment;
import xml.MyAppointments;
import xml.MyPatients;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    // TODO: DELETE, PUT

}
