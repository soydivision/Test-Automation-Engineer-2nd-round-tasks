package exceptions;

public class InvalidMarkException extends IllegalArgumentException {
    public InvalidMarkException() {
    }

    public InvalidMarkException(String message) {
        super(message);
    }

    public InvalidMarkException(String message, Throwable cause) {
        super(message, cause);
    }
}