package Student;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class StudentRunner {
    public static void main(String[] args) {
        Student.PersonalData personalDataStudent1 = new Student.PersonalData("Andrei", "Lazarchik",
                "Valerevich", new GregorianCalendar(1982, Calendar.APRIL, 20));
        Student.EducationData educationDataStudent1 = new Student.EducationData("IBR", "1",
                "UVED-3");
        Student student1 = new Student(1, personalDataStudent1, "Minsk", "+375293385197",
                educationDataStudent1);

        Student.PersonalData personalDataStudent2 = new Student.PersonalData("Dmitriy", "Koltsov",
                "Sergeevich", new GregorianCalendar(1975, Calendar.SEPTEMBER, 15));
        Student.EducationData educationDataStudent2 = new Student.EducationData("IBR", "4",
                "UVED-1");
        Student student2 = new Student(2, personalDataStudent2, "Grodno", "+375447331541",
                educationDataStudent2);

        Student.PersonalData personalDataStudent3 = new Student.PersonalData("Maxim", "Repin",
                "Olegovich", new GregorianCalendar(1983, Calendar.DECEMBER, 1));
        Student.EducationData educationDataStudent3 = new Student.EducationData("FMK", "4",
                "FMK-4");
        Student student3 = new Student(3, personalDataStudent3, "Vitebsk", "+375257215987",
                educationDataStudent3);

        Student.addStudentToList(student1);
        Student.addStudentToList(student2);
        Student.addStudentToList(student3);

        Student.searchDepartment("IBR");
        Student.searchDepartmentAndCourse("IBR", "4");
        Student.searchYoungerStudents(1982);
        Student.searchGroup("FMK", "4", "FMK-4");
    }
}
