package newMainTask;

import newMainTask.exceptions.NoStudentsInGroupException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Group extends ArrayList<Student> {
    private final String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student getStudent(String studentName) {
        Student result = null;
        for (Student student : this) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                result = student;
            }
        }
        if (result == null) {
            throw new NoSuchElementException("There is no such a student at this group");
        }
        return result;
    }

    public double getAverageGrade(Subjects subject) throws NoStudentsInGroupException {
        if (this.isEmpty()) {
            throw new NoStudentsInGroupException();
        }
        double sumOfGrades = 0;
        int gradesCounter = 0;
        for (Student student : this) {
            for (Grade grade : student) {
                if (grade.getSubject().equals(subject)) {
                    sumOfGrades += grade.getGrade();
                    gradesCounter++;
                }
            }
        }
        double result = sumOfGrades / gradesCounter;
        if (!Double.isNaN(result)) {
            return result;
        } else {
            return 0;
        }
    }

    public void printOutAverageGrade(Subjects subject) throws NoStudentsInGroupException {
        System.out.printf("Average grade of group " + this.getName() + " for "
                + subject + " is: %.1f%n", this.getAverageGrade(subject));
    }
}
