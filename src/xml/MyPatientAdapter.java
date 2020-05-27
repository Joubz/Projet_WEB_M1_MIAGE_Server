package xml;

import businessLogic.MyPatient;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyPatientAdapter extends XmlAdapter<String, MyPatient> {
    @Override
    public MyPatient unmarshal(String s) throws Exception {
        System.out.println("unmarshal");

        MyPatients myPatients = new MyPatients();
        myPatients.decode();

        System.out.println(s);

        if (myPatients.getPatients().isEmpty()) {
            System.out.println("null");
            return null;
        } else {
            for (MyPatient patient: myPatients.getPatients()) {
                if (patient.getId().equals(s)) {
                    System.out.println(patient.getId());
                    return patient;
                }
            }

            return null;
        }
    }

    @Override
    public String marshal(MyPatient patient) throws Exception {
        System.out.println("marshal");
        return patient.getId();
    }

}
