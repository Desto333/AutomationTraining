package MainTask.Exceptions;

public class NoStudentsInGroupExceptions extends Exception{
    public NoStudentsInGroupExceptions() {
    }

    public NoStudentsInGroupExceptions(String message) {
        super(message);
    }

    public NoStudentsInGroupExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInGroupExceptions(Throwable cause) {
        super(cause);
    }

    public NoStudentsInGroupExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
