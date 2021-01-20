package newMainTask.exceptions;

public class IncorrectGradeValueException extends Exception{
    public IncorrectGradeValueException() {
        super("Incorrect grade! Must have value between 0 and 10.");
    }

    public IncorrectGradeValueException(String message) {
        super(message);
    }

    public IncorrectGradeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectGradeValueException(Throwable cause) {
        super(cause);
    }

    public IncorrectGradeValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
