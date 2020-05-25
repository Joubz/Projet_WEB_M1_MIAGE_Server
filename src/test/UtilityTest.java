package test;

import businessLogic.Utility;
import org.junit.Assert;
import org.junit.Test;


/**
 * Class where we test all main.Utility class methods
 */
public class UtilityTest {

    @Test
    public final void testEmailRegex() {
        String wrongEmail = "test";
        String rightEmail = "test@gmail.com";
        String nothing = "";

        Assert.assertFalse(Utility.emailValidated(wrongEmail));
        Assert.assertFalse(Utility.emailValidated(nothing));

        Assert.assertTrue(Utility.emailValidated(rightEmail));


    }

    @Test
    public final void testPhoneRegex() {
        String wrongPhone = "a";
        String wrongPhoneTwo = "0654";
        String rightPhone = "0123456789";
        String nothing = "";

        Assert.assertFalse(Utility.phoneValidated(wrongPhone));
        Assert.assertFalse(Utility.phoneValidated(wrongPhoneTwo));
        Assert.assertFalse(Utility.phoneValidated(nothing));

        Assert.assertTrue(Utility.phoneValidated(rightPhone));


    }

    @Test
    public final void testNameRegex() {
        String firstNameOne = "Leo";
        String firstNameTwo = "Leo1";
        String lastNameOne = "Name";
        String lastNameTwo = "Name1";

        Assert.assertFalse(Utility.nameValidated(firstNameOne, lastNameTwo));
        Assert.assertFalse(Utility.nameValidated(firstNameTwo, lastNameOne));
        Assert.assertTrue(Utility.nameValidated(firstNameOne, lastNameOne));

    }

    @Test
    public final void testDateRegex() {
        String dateOne = "20/12/2017";
        String dateTwo = "20-12-2017";
        String dateThree = "20 12 2017";

        Assert.assertTrue(Utility.dateValidated(dateTwo));
        Assert.assertTrue(Utility.dateValidated(dateOne));
        Assert.assertFalse(Utility.dateValidated(dateThree));

    }

}
