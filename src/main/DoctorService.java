package main;

import businessLogic.MyDoctor;
import xml.MyDoctors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/Doctors")
public class DoctorService {

    // Attributes

    MyDoctors myDoctors = new MyDoctors();

    /**
     * Default Constructor
     */
    public DoctorService() {
        this.myDoctors.decode();

        if (this.myDoctors.getDoctors().isEmpty()) {
            this.myDoctors.add(new MyDoctor("PISSOTTE", "Alexandre", "Homéopathe", "16 av de Collegno, 33400 Talence", 9, 12, 14, 16, 30));
            this.myDoctors.add(new MyDoctor("JOUBERT", "Nathan", "Généraliste", "34 rue du Temple 33000 Bordeaux", 9, 12, 15, 18, 20));
            this.myDoctors.add(new MyDoctor("BASCOUZARAIX", "Julien", "Osthéopathe", "36 rue du Temple 33000 Bordeaux", 9, 12, 14, 17, 60));

            this.myDoctors.encode();
        }
    }

    /**
     * URL : http://localhost:8080/BordeauxMedicServer_war_exploded/Doctors | Get all doctors information
     * @return All doctors information
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctors() {
        return Response.ok().entity(this.myDoctors.getDoctors())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

}
