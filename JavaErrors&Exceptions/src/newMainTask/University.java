package newMainTask;

import newMainTask.exceptions.NoDepartmentsAtUniversityException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class University extends ArrayList<Department> {
    private final String name;

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment(String departmentName) {
        Department result = null;
        for (Department department : this) {
            if (department.getName().equalsIgnoreCase(departmentName)) {
                result = department;
            }
        }
        if (result == null) {
            throw new NoSuchElementException("There is no such a department at this university");
        }
        return result;
    }

    public double getAverageGrade(Subjects subject) throws NoDepartmentsAtUniversityException {
        if (this.isEmpty()) {
            throw new NoDepartmentsAtUniversityException();
        }
        double sumOfGradesAtDepartment = 0.0;
        int gradesCounter = 0;
        for (Department department : this) {
            for (Group group : department) {
                for (Student student : group) {
                    if (!student.isEmpty() && student.study(subject)) {
                        sumOfGradesAtDepartment += student.getGrade(subject);
                        gradesCounter++;
                    }
                }
            }
        }
        return sumOfGradesAtDepartment / gradesCounter;
    }

    public void printOutAverageGrade(Subjects subject) throws NoDepartmentsAtUniversityException {
        System.out.printf("Average grade of university " + this.getName() + " for " + subject
                + " is: %.1f%n", this.getAverageGrade(subject));
    }
}
