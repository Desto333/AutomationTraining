package newMainTask;

import newMainTask.exceptions.*;

public class Runner {
    public static void main(String[] args) throws NoSubjectsException, IncorrectGradeValueException, NoStudentsInGroupException, NoGroupsAtDepartmentException, NoDepartmentsAtUniversityException {
        University bseu = new University("BSEU");
        University bsu = new University("BSU");

        bseu.add(new Department("FMEO"));
        bseu.add(new Department("FMK"));
        bseu.add(new Department("FM"));

        bseu.getDepartment("FMEO").add(new Group("UVED-1"));
        bseu.getDepartment("FMK").add(new Group("DML-2"));
        bseu.getDepartment("FMK").add(new Group("DML-3"));

        bseu.getDepartment("FMEO").getGroup("UVED-1").add(new Student("Ivanov Ivan"));
        bseu.getDepartment("FMEO").getGroup("UVED-1").add(new Student("Petrov Petr"));
        bseu.getDepartment("FMEO").getGroup("UVED-1").add(new Student("Sidorov Sidor"));

        bseu.getDepartment("FMK").getGroup("DML-2").add(new Student("Sergeev Sergei"));
        bseu.getDepartment("FMK").getGroup("DML-2").add(new Student("Dmitriev Dmitriy"));
        bseu.getDepartment("FMK").getGroup("DML-2").add(new Student("Korobova Anna"));
        bseu.getDepartment("FMK").getGroup("DML-2").add(new Student("Eliseev Semen"));

        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Ivanov Ivan")
                .add(new Grade(Subjects.ECONOMICS, 8));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Ivanov Ivan")
                .add(new Grade(Subjects.ENGLISH, 7));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Ivanov Ivan")
                .add(new Grade(Subjects.WORLD_ECONOMY, 9));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Ivanov Ivan")
                .add(new Grade(Subjects.FRENCH, 7));

        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Petrov Petr")
                .add(new Grade(Subjects.ECONOMICS, 5));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Petrov Petr")
                .add(new Grade(Subjects.ENGLISH, 6));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Petrov Petr")
                .add(new Grade(Subjects.WORLD_ECONOMY, 7));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Petrov Petr")
                .add(new Grade(Subjects.FRENCH, 8));

        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Sidorov Sidor")
                .add(new Grade(Subjects.ECONOMICS, 9));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Sidorov Sidor")
                .add(new Grade(Subjects.ENGLISH, 10));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Sidorov Sidor")
                .add(new Grade(Subjects.WORLD_ECONOMY, 10));
        bseu.getDepartment("FMEO").getGroup("UVED-1").getStudent("Sidorov Sidor")
                .add(new Grade(Subjects.FRENCH, 8));

        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Sergeev Sergei")
                .add(new Grade(Subjects.ECONOMICS, 6));
        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Sergeev Sergei")
                .add(new Grade(Subjects.ENGLISH, 5));
        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Sergeev Sergei")
                .add(new Grade(Subjects.MARKETING, 6));
        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Sergeev Sergei")
                .add(new Grade(Subjects.HISTORY, 4));

        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Dmitriev Dmitriy")
                .add(new Grade(Subjects.ECONOMICS, 7));
        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Dmitriev Dmitriy")
                .add(new Grade(Subjects.ENGLISH, 9));
        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Dmitriev Dmitriy")
                .add(new Grade(Subjects.MARKETING, 8));
        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Dmitriev Dmitriy")
                .add(new Grade(Subjects.HISTORY, 8));

        bseu.getDepartment("FMK").getGroup("DML-2").getStudent("Korobova Anna")
                .add(new Grade(Subjects.HISTORY, 2));

        bseu.getDepartment("FMK").getGroup("DML-2")
                .getStudent("Sergeev Sergei").printOutAverageGrade();

        bseu.getDepartment("FMEO").getGroup("UVED-1").printOutAverageGrade(Subjects.ENGLISH);
        bseu.getDepartment("FMEO").printOutAverageGrade(Subjects.WORLD_ECONOMY);
        bseu.printOutAverageGrade(Subjects.MARKETING);
    }
}
