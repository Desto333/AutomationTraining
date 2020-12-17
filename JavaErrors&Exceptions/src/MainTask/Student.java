package MainTask;

import MainTask.Exceptions.IncorrectGradeException;
import MainTask.Exceptions.NoSubjectsException;

import java.util.HashMap;

public class Student {
    private String studentName;
    private HashMap<String, Integer> subjectsAndGrades;

    public Student(String studentName, HashMap<String, Integer> subjectsAndGrades) throws NoSubjectsException, IncorrectGradeException {
        this.studentName = studentName;
        this.subjectsAndGrades = subjectsAndGrades;
        if (subjectsAndGrades.isEmpty()
                || subjectsAndGrades.keySet().stream().anyMatch(subject -> subject.equals(""))) {
            throw new NoSubjectsException("Student has no subjects. Must be at least 1.");
        }
        if (subjectsAndGrades.values().stream().anyMatch(value -> (value < 0) || (value > 10))) {
            throw new IncorrectGradeException("Grade must be from 0 to 10.");
        }
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public HashMap<String, Integer> getSubjects() {
        return subjectsAndGrades;
    }

    public void setSubjects(HashMap<String, Integer> subjectsAndGrades) throws NoSubjectsException, IncorrectGradeException {
        this.subjectsAndGrades = subjectsAndGrades;
        if (subjectsAndGrades.isEmpty()
                || subjectsAndGrades.keySet().stream().anyMatch(subject -> subject.equals(""))) {
            throw new NoSubjectsException("Student has no subjects. Must be at least 1.");
        }
        if (subjectsAndGrades.values().stream().anyMatch(value -> (value < 0) || (value > 10))) {
            throw new IncorrectGradeException("Grade must be from 0 to 10.");
        }
    }
}
