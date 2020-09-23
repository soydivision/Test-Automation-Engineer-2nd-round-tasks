package exceptions;

public class NoSuchSubjectsException extends RuntimeException {
    public NoSuchSubjectsException() {
    }

    public NoSuchSubjectsException(String message) {
        super(message);
    }

    public NoSuchSubjectsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchSubjectsException(Throwable cause) {
        super(cause);
    }
}