import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Emre YILDIZ
 */
public class ValidateISBNTest {
    private static final ValidateISBN validator = new ValidateISBN();
    @Test
    public void checkAValidISBN()
    {
        assertTrue("first",validator.checkISBN("0486284735"));
        assertTrue("second",validator.checkISBN("0486284735"));
    }
    @Test
    public void checkAnInValidISBN()
    {
        assertFalse(validator.checkISBN("0140449117"));
    }
    @Test
    public void tenDigitISBNNumberEndingInAnXAreValid()
    {
        assertTrue(validator.checkISBN("012000030X"));
        assertTrue(validator.checkISBN("1644136201"));
    }
    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreAllowed()
    {
        validator.checkISBN("123456789");
    }
    @Test(expected = NumberFormatException.class)
    public void nonNumericIsNotAllowed()
    {
        validator.checkISBN("helloWorld");
    }
    @Test
    public void thirteenDigitISBNIsAllowed()
    {
        assertTrue("1", validator.checkISBN("9780063225930"));
        assertTrue("2",validator.checkISBN("9780310777021"));
        assertTrue("3",validator.checkISBN("9781644132111"));
        assertTrue("4",validator.checkISBN("9781644136201"));
    }

}
