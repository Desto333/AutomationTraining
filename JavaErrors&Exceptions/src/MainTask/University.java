package MainTask;

import MainTask.Exceptions.NoDepartmentsAtUniversityException;

import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList<Department> listOfDepartments;

    public University(String universityName, ArrayList<Department> listOfDepartments) throws NoDepartmentsAtUniversityException {
        this.universityName = universityName;
        this.listOfDepartments = listOfDepartments;
        if (listOfDepartments.isEmpty()) {
            throw new NoDepartmentsAtUniversityException("There are no departments at University. Must be at least 1.");
        }
    }

    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Department> getListOfDepartments() {
        return listOfDepartments;
    }

    public void setListOfDepartments(ArrayList<Department> listOfDepartments) throws NoDepartmentsAtUniversityException {
        this.listOfDepartments = listOfDepartments;
        if (listOfDepartments.isEmpty()) {
            throw new NoDepartmentsAtUniversityException("There are no departments at University. Must be at least 1.");
        }
    }
}
