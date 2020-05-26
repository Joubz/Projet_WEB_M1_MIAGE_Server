package businessLogic;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


/**
 * This class represents a doctor and all his information
 */
@Root(name = "doctors")
public class Doctors {

    @ElementList(entry = "doctor", inline = true)
    List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
