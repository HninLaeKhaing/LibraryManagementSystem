package exceptions;

/**
 * Custom exception thrown when a requested book is not available for issuing.
 */
public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String message) {
        super(message);
    }

    public BookNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
