package MainTask.Exceptions;

public class NoGroupsAtDepartmentException extends Exception {
    public NoGroupsAtDepartmentException() {
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
