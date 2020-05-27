package xml;

import businessLogic.MyDoctor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyDoctorAdapter extends XmlAdapter<String, MyDoctor> {

    @Override
    public MyDoctor unmarshal(String o) throws Exception {
        System.out.println("unmarshal");

        MyDoctors myDoctors = new MyDoctors();
        myDoctors.decode();

        System.out.println(o);

        if (myDoctors.getDoctors().isEmpty()) {
            System.out.println("null");
            return null;
        } else {
            for (MyDoctor doctor: myDoctors.getDoctors()) {
                if (doctor.getId().equals(o)) {
                    System.out.println(doctor.getId());
                    return doctor;
                }
            }

            return null;
        }
    }

    @Override
    public String marshal(MyDoctor o) throws Exception {
        System.out.println("marshal");
        return o.getId();
    }
}
