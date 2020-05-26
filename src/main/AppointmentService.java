package main;

import businessLogic.*;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/appointments")
public class AppointmentService {

    @GET
    @Produces("application/json")
    public Response getAppointments() throws Exception {
        try {
            XML xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\appointment.xml"));
            String xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<", "<");

            Serializer serializer = new Persister();
            Appointments appointments =  serializer.read(Appointments.class, xmlString);

            xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\doctor.xml"));
            xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<", "<");

            serializer = new Persister();
            Doctors doctors =  serializer.read(Doctors.class, xmlString);

            xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\patient.xml"));
            xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<", "<");

            serializer = new Persister();
            Patients patients =  serializer.read(Patients.class, xmlString);

            for (Appointment appointment : appointments.getAppointments()) {
                for (Doctor doctor : doctors.getDoctors()) {
                    if(doctor.getId() == appointment.getId())
                        appointment.setDoctor(doctor);
                }
                for (Patient patient : patients.getPatients()) {
                    if (patient.getId() == appointment.getId())
                        appointment.setPatient(patient);
                }
            }

            return Response.ok().entity(appointments)
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

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getAppointment(@PathParam("id") int id) throws Exception {
        try {
            XML xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\appointment.xml"));
            String xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<", "<");

            Serializer serializer = new Persister();
            Appointments appointments =  serializer.read(Appointments.class, xmlString);

            xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\doctor.xml"));
            xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<", "<");

            serializer = new Persister();
            Doctors doctors =  serializer.read(Doctors.class, xmlString);

            xml = new XMLDocument(new File("C:\\Users\\Julien\\IdeaProjects\\BordeauxMedicServer\\src\\xml\\patient.xml"));
            xmlString = xml.toString();
            xmlString = xmlString.trim().replaceFirst("^([\\W]+)<", "<");

            serializer = new Persister();
            Patients patients =  serializer.read(Patients.class, xmlString);

            for (Appointment appointment : appointments.getAppointments()) {
                if (appointment.getId() == id) {
                    for (Doctor doctor : doctors.getDoctors()) {
                        if(doctor.getId() == appointment.getId())
                            appointment.setDoctor(doctor);
                    }
                    for (Patient patient : patients.getPatients()) {
                        if (patient.getId() == appointment.getId())
                            appointment.setPatient(patient);
                    }
                    return Response.ok().entity(appointment)
                            .header("Access-Control-Allow-Origin", "*")
                            .header("Access-Control-Allow-Credentials", "true")
                            .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                            .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                            .build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
