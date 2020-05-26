package businessLogic;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.regex.Pattern;

public class Utility {

    /**
     * @param phone: phone string that will be verify by a regex
     * @return true if the regex is good when it's compared to phone string, otherwise the function return false
     */
    public static boolean phoneValidated(String phone) {
        Pattern pattern = Pattern.compile("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$");
        return pattern.matcher(phone).find();
    }


    /**
     * @param email: email string that will be verify by a regex
     * @return true if the regex is good when it's compared to email string, otherwise the function return false
     */
    public static boolean emailValidated(String email) {
        Pattern pattern = Pattern.compile("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f]" +
                ")*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2" +
                "[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)" +
                "\\])$");
        return pattern.matcher(email).find();
    }

    /**
     * @param firstName: patient first name that will be verify by a regex
     * @param lastName:  patient last name that will be verify by a regex
     * @return true if the regex is good when it's compared to first and last name string, otherwise the function
     * return false
     */
    public static boolean nameValidated(String firstName, String lastName) {
        Pattern pattern = Pattern.compile("^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉ" +
                "ÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$");
        return pattern.matcher(firstName).find() && pattern.matcher(lastName).matches();
    }

    /**
     * string date that will be verify by a regex
     *
     * @param date: string date that will be verify by a regex
     * @return true if the regex is good when it's compared to date string, otherwise the function return false
     */
    public static boolean dateValidated(String date) {
        Pattern pattern = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?" +
                "[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?" +
                "(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])" +
                "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        return pattern.matcher(date).find();
    }

}
