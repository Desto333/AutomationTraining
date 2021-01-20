package newMainTask.exceptions;

public class NoSubjectsException extends Exception{
    public NoSubjectsException() {
        super("Student has no subjects! Must be at least 1.");
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

    public NoSubjectsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
