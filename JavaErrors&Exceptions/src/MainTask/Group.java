package MainTask;

import MainTask.Exceptions.NoStudentsInGroupExceptions;

import java.util.ArrayList;

public class Group {
    private String groupName;
    private ArrayList<Student> listOfStudents;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, ArrayList<Student> listOfStudents) throws NoStudentsInGroupExceptions {
        this.groupName = groupName;
        this.listOfStudents = listOfStudents;
        if (listOfStudents.isEmpty()) {
            throw new NoStudentsInGroupExceptions("There is no students in group. Must be at least 1.");
        }
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) throws NoStudentsInGroupExceptions {
        this.listOfStudents = listOfStudents;
        if (listOfStudents.isEmpty()) {
            throw new NoStudentsInGroupExceptions("There is no students in group. Must be at least 1.");
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
