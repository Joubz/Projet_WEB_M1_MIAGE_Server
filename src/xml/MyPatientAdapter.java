package xml;

import businessLogic.MyPatient;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyPatientAdapter extends XmlAdapter<String, MyPatient> {

    /**
     * Method for complex xml object
     *
     * @param s (String)
     * @return (MyPatient)
     */
    @Override
    public MyPatient unmarshal(String s) {
        System.out.println("unmarshal");

        MyPatients myPatients = new MyPatients();
        myPatients.decode();

        System.out.println(s);

        if (myPatients.getPatients().isEmpty()) {
            System.out.println("null");
            return null;
        } else {
            for (MyPatient patient : myPatients.getPatients()) {
                if (patient.getId().equals(s)) {
                    System.out.println(patient.getId());
                    return patient;
                }
            }

            return null;
        }
    }

    /**
     * Method for complex xml object
     *
     * @param patient (MyPatient)
     * @return patient get id
     */
    @Override
    public String marshal(MyPatient patient) {
        System.out.println("marshal");
        return patient.getId();
    }

}
