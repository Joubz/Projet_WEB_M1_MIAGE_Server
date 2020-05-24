import static org.junit.Assert.*;


import org.junit.Test;


/**
 * Class where we test all Utility class methods
 */
public class UtilityTest {

    @Test
    public final void testEmailRegex() {
        String wrongEmail = "test";
        String rightEmail = "test@gmail.com";
        String nothing = "";

        assertFalse(Utility.emailValidated(wrongEmail));
        assertFalse(Utility.emailValidated(nothing));

        assertTrue(Utility.emailValidated(rightEmail));


    }

    @Test
    public final void testPhoneRegex() {
        String wrongPhone = "a";
        String wrongPhoneTwo = "0654";
        String rightPhone = "0123456789";
        String nothing = "";

        assertFalse(Utility.phoneValidated(wrongPhone));
        assertFalse(Utility.phoneValidated(wrongPhoneTwo));
        assertFalse(Utility.phoneValidated(nothing));

        assertTrue(Utility.phoneValidated(rightPhone));


    }

    @Test
    public final void testNameRegex() {
        String firstNameOne = "Leo";
        String firstNameTwo = "Leo1";
        String lastNameOne = "Name";
        String lastNameTwo = "Name1";

        assertFalse(Utility.nameValidated(firstNameOne, lastNameTwo));
        assertFalse(Utility.nameValidated(firstNameTwo, lastNameOne));
        assertTrue(Utility.nameValidated(firstNameOne, lastNameOne));

    }

    @Test
    public final void testDateRegex() {
        String dateOne = "20/12/2017";
        String dateTwo = "20-12-2017";
        String dateThree = "20 12 2017";

        assertTrue(Utility.dateValidated(dateTwo));
        assertTrue(Utility.dateValidated(dateOne));
        assertFalse(Utility.dateValidated(dateThree));

    }

}
