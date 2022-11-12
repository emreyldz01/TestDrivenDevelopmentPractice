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
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first",result);
        result = validator.checkISBN("0140177396");
        assertTrue("second",result);
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
        assertFalse(result);
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
}
