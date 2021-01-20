package newMainTask;

import newMainTask.exceptions.IncorrectGradeValueException;

public class Grade {
    private final Subjects subject;
    private final double grade;

    public Grade(Subjects subject, int grade) throws IncorrectGradeValueException {
        if (grade < 0 || grade > 10) {
            throw new IncorrectGradeValueException();
        }
        this.subject = subject;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public Subjects getSubject() {
        return subject;
    }
}
