package MainTask;

import MainTask.Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {

        try {
            Student student1 = new Student("Ivanov Ivan");
            student1.setSubjects(new HashMap<>() {{
                put("Economics", 8);
                put("English", 7);
                put("World Economy", 9);
                put("French", 7);
            }});
            Student student2 = new Student("Petrov Petr");
            student2.setSubjects(new HashMap<>() {{
                put("Economics", 5);
                put("English", 6);
                put("World Economy", 7);
                put("French", 8);
            }});
            Student student3 = new Student("Sidorov Sidor");
            student3.setSubjects(new HashMap<>() {{
                put("Economics", 9);
                put("English", 10);
                put("World Economy", 10);
                put("French", 8);
            }});
            Student student4 = new Student("Sergeev Sergei");
            student4.setSubjects(new HashMap<>() {{
                put("Economics", 6);
                put("English", 5);
                put("Marketing", 6);
                put("History", 4);
            }});
            Student student5 = new Student("Dmitriev Dmitriy");
            student5.setSubjects(new HashMap<>() {{
                put("Economics", 7);
                put("English", 9);
                put("Marketing", 8);
                put("History", 8);
            }});
            Student student6 = new Student("Korobova Anna");
            student6.setSubjects(new HashMap<>() {{
                put("History", 2);
            }});

            Group uved1 = new Group("UVED-1");
            uved1.setListOfStudents(new ArrayList<>() {{
                add(student1);
                add(student2);
                add(student3);
            }});
            Group dml2 = new Group("DML-2");
            dml2.setListOfStudents(new ArrayList<>() {{
                add(student4);
                add(student5);
                add(student6);
            }});
//            Group dml3 = new Group("DML-3", new ArrayList<>());

            Department fmeo = new Department("FMEO", new ArrayList<>() {{
                add(uved1);
            }});
            Department fmk = new Department("FMK", new ArrayList<>() {{
                add(dml2);
//                add(dml3);
            }});
//            Department fm = new Department("FM", new ArrayList<>());

            University bseu = new University("BSEU", new ArrayList<>() {{
                add(fmeo);
                add(fmk);
//                add(fm);
            }});
//            University bsu = new University("BSU", new ArrayList<>());

            GradesCount.calculateAverageGradeForStudent(student1);
            GradesCount.calculateAverageGradeForSubjectAtGroup("French", uved1);
            GradesCount.calculateAverageGradeForSubjectAtUniversity("History", bseu);

        } catch (NoSubjectsException | IncorrectGradeException | NoStudentsInGroupExceptions
                | NoGroupsAtDepartmentException | NoDepartmentsAtUniversityException e) {
            System.err.println(e);
        }
    }
}
