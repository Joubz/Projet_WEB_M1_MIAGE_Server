package xml;

import businessLogic.MyDoctor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Class for complex xml object
 */
public class MyDoctorAdapter extends XmlAdapter<String, MyDoctor> {

    /**
     * Methods for complex xml object
     *
     * @param o (String)
     * @return (MyDoctor)
     */
    @Override
    public MyDoctor unmarshal(String o) {
        System.out.println("unmarshal");

        MyDoctors myDoctors = new MyDoctors();
        myDoctors.decode();

        System.out.println(o);

        if (myDoctors.getDoctors().isEmpty()) {
            System.out.println("null");
            return null;
        } else {
            for (MyDoctor doctor : myDoctors.getDoctors()) {
                if (doctor.getId().equals(o)) {
                    System.out.println(doctor.getId());
                    return doctor;
                }
            }

            return null;
        }
    }

    /**
     * Methods for complex xml object
     *
     * @param o (MyDoctor)
     * @return (String)
     */
    @Override
    public String marshal(MyDoctor o) {
        System.out.println("marshal");
        return o.getId();
    }
}
