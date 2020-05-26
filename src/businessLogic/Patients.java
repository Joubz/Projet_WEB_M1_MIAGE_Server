package businessLogic;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "patients")
public class Patients {

    @ElementList(entry = "patient", inline = true)
    private List<Patient> patients;

    /**
     * get all patients information
     * @return all patients information
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Setter for patient list
     * @param patients
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
