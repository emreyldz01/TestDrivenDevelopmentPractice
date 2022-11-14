import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Emre YILDIZ
 */
public class ValidateISBNTest {
    @Test
    public void checkAValidISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0486284735");
        assertTrue("first",result);

    }
    @Test
    public void checkAnInValidISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }
    @Test
    public void ISBNNumberEndingInAnXAreValid()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }
    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreAllowed()
    {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }
    @Test(expected = NumberFormatException.class)
    public void nonNumericIsNotAllowed()
    {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloWorld");
    }
    @Test
    public void thirteenDigitISBNIsAllowed()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9871853260087");
        assertTrue(result);
    }
}
