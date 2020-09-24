package exceptions;

public class EmptyUniversityException extends IllegalArgumentException {
    public EmptyUniversityException() {
    }

    public EmptyUniversityException(String message) {
        super(message);
    }

    public EmptyUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyUniversityException(Throwable cause) {
        super(cause);
    }
}