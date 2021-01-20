package newMainTask.exceptions;

public class NoStudentsInGroupException extends Exception{
    public NoStudentsInGroupException() {
        super("There are no students in this group! Must be at least 1.");
    }

    public NoStudentsInGroupException(String message) {
        super(message);
    }

    public NoStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInGroupException(Throwable cause) {
        super(cause);
    }

    public NoStudentsInGroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
