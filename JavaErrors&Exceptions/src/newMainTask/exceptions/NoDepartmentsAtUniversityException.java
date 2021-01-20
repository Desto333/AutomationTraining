package newMainTask.exceptions;

public class NoDepartmentsAtUniversityException extends Exception{
    public NoDepartmentsAtUniversityException() {
        super("There are no departments at this university! Must be at least 1.");
    }

    public NoDepartmentsAtUniversityException(String message) {
        super(message);
    }

    public NoDepartmentsAtUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDepartmentsAtUniversityException(Throwable cause) {
        super(cause);
    }

    public NoDepartmentsAtUniversityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
