package MainTask.Exceptions;

public class IncorrectGradeException extends Exception {
    public IncorrectGradeException() {
    }

    public IncorrectGradeException(String message) {
        super(message);
    }

    public IncorrectGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectGradeException(Throwable cause) {
        super(cause);
    }

    public IncorrectGradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
