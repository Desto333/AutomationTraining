package newMainTask.exceptions;

public class NoGroupsAtDepartmentException extends Exception{
    public NoGroupsAtDepartmentException() {
        super("There are no groups at this department! Must be at least 1.");
    }

    public NoGroupsAtDepartmentException(String message) {
        super(message);
    }

    public NoGroupsAtDepartmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupsAtDepartmentException(Throwable cause) {
        super(cause);
    }

    public NoGroupsAtDepartmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
