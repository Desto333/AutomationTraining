package MainTask;

import MainTask.Exceptions.NoGroupsAtDepartmentException;

import java.util.ArrayList;

public class Department {
    private String departmentName;
    private ArrayList<Group> listOfGroups;

    public Department(String departmentName, ArrayList<Group> listOfGroups) throws NoGroupsAtDepartmentException {
        this.departmentName = departmentName;
        this.listOfGroups = listOfGroups;
        if (listOfGroups.isEmpty()) {
            throw new NoGroupsAtDepartmentException("There are no groups at department. Must be at least 1.");
        }
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<Group> getListOfGroups() {
        return listOfGroups;
    }

    public void setListOfGroups(ArrayList<Group> listOfGroups) throws NoGroupsAtDepartmentException {
        this.listOfGroups = listOfGroups;
        if (listOfGroups.isEmpty()) {
            throw new NoGroupsAtDepartmentException("There are no groups at department. Must be at least 1.");
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
