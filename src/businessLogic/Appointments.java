package businessLogic;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "appointments")
public class Appointments {

    @ElementList(entry = "appointment", inline = true)
    List<Appointment> appointments;

    /**
     * Get all appointments
     * @return all appointments
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Setter for appointments list
     * @param appointments (List<Appointment>)
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
