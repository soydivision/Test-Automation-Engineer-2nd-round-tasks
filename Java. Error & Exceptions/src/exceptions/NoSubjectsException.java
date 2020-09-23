package exceptions;

public class NoSubjectsException extends RuntimeException {
    public NoSubjectsException() {
    }

    public NoSubjectsException(String message) {
        super(message);
    }

    public NoSubjectsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubjectsException(Throwable cause) {
        super(cause);
    }
}