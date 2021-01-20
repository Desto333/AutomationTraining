package newMainTask;

import newMainTask.exceptions.NoSubjectsException;

import java.util.ArrayList;

public class Student extends ArrayList<Grade> {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean study(Subjects subject) {
        boolean result = false;
        for (Grade grade : this) {
            if (grade.getSubject().equals(subject)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public double getGrade(Subjects subject) {
        double result = 0;
        for (Grade grade : this) {
            if (grade.getSubject().equals(subject)) {
                result = grade.getGrade();
                break;
            }
        }
        return result;
    }

    public void printOutAverageGrade() throws NoSubjectsException {
        if (this.isEmpty()) {
            throw new NoSubjectsException();
        }
        double sum = 0;
        for (Grade grade : this) {
            sum += grade.getGrade();
        }
        System.out.printf("Average grade of student " + this.getName() + " is %.1f%n", sum / this.size());
    }
}
