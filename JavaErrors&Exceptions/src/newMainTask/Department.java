package newMainTask;

import newMainTask.exceptions.NoGroupsAtDepartmentException;
import newMainTask.exceptions.NoStudentsInGroupException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Department extends ArrayList<Group> {
    private final String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Group getGroup(String groupName) {
        Group result = null;
        for (Group group : this) {
            if (group.getName().equalsIgnoreCase(groupName)) {
                result = group;
            }
        }
        if (result == null) {
            throw new NoSuchElementException("There is no such a group at this department");
        }
        return result;
    }

    public double getAverageGrade(Subjects subject) throws NoStudentsInGroupException, NoGroupsAtDepartmentException {
        if (this.isEmpty()) {
            throw new NoGroupsAtDepartmentException();
        }
        double sumOfAverageGradesAtGroups = 0.0;
        int averageGradesCounter = 0;
        for (Group group : this) {
            sumOfAverageGradesAtGroups += group.getAverageGrade(subject);
            averageGradesCounter++;
        }
        double result = sumOfAverageGradesAtGroups / averageGradesCounter;
        if (!Double.isNaN(result)) {
            return result;
        } else {
            return 0;
        }
    }

    public void printOutAverageGrade(Subjects subject) throws NoStudentsInGroupException, NoGroupsAtDepartmentException {
        System.out.printf("Average grade of department " + this.getName() + " for " + subject
                + " is: %.1f%n", this.getAverageGrade(subject));
    }
}
