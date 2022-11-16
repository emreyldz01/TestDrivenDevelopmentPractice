/**
 * @author Emre YILDIZ
 */
public class ValidateISBN {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;
    private static final int SHORT_ISBN_MULTIPLIER = 11;
    private static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == LONG_ISBN_LENGTH) {
            return isThisAValid13DigitISBN(isbn);
        } else {
            if (isbn.length() != SHORT_ISBN_LENGTH) {
                throw new NumberFormatException("ISBN must be 10 digit long");
            }
            return isThisAValid10DigitISBN(isbn);
        }
    }

    private static boolean isThisAValid10DigitISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(isbn.length() - 1) == 'X') {
                    total += SHORT_ISBN_LENGTH;
                } else {
                    throw new NumberFormatException("ISBN characters must be digit");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
            }
        }
        if (total % SHORT_ISBN_MULTIPLIER == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isThisAValid13DigitISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        if (total % LONG_ISBN_MULTIPLIER == 0) {
            return true;
        } else {
            return false;
        }
    }
}
