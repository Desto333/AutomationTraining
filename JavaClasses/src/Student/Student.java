package Student;

//1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.

//Создать массив объектов. Вывести:
//a) список студентов заданного факультета;
//b) списки студентов для каждого факультета и курса;
//c) список студентов, родившихся после заданного года;
//d) список учебной группы.

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Student {
    public static List<Student> listOfStudents = new ArrayList<>();

    public long id;
    public PersonalData personalData;
    public String address;
    public String phoneNumber;
    public EducationData educationData;

    public Student(long id, PersonalData personalData, String address, String phoneNumber, EducationData educationData) {
        this.id = id;
        this.personalData = personalData;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.educationData = educationData;
    }

    public Student(long id, PersonalData personalData, String address, String phoneNumber) {
        this.id = id;
        this.personalData = personalData;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static class PersonalData {
        String firstName;
        String lastName;
        String middleName;
        Calendar dateOfBirth;

        public PersonalData(String firstName, String lastName, String middleName, Calendar dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.dateOfBirth = dateOfBirth;
        }

        public PersonalData(String firstName, String lastName, Calendar dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
        }
    }

    public static class EducationData {
        String department;
        String yearOfStudy;
        String group;

        public EducationData(String department, String yearOfStudy, String group) {
            this.department = department;
            this.yearOfStudy = yearOfStudy;
            this.group = group;
        }
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        Student.listOfStudents = listOfStudents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void addStudentToList(Student student) {
        listOfStudents.add(student);
    }

    public static void searchDepartment(String dep) {
        listOfStudents.forEach(student -> {
            if (student.educationData.department.equals(dep)) {
                System.out.println(student);
            }
        });
    }

    public static void searchDepartmentAndCourse(String dep, String year) {
        listOfStudents.forEach(student -> {
            if (student.educationData.department.equals(dep) && student.educationData.yearOfStudy.equals(year)) {
                System.out.println(student);
            }
        });
    }

    public static void searchYoungerStudents(int yearOfBirth) {
        listOfStudents.forEach(student -> {
            if (student.personalData.dateOfBirth.after(new GregorianCalendar(yearOfBirth, 1, 1))) {
                System.out.println(student);
            }
        });
    }

    public static void searchGroup(String dep, String year, String grp) {
        listOfStudents.forEach(student -> {
            if (student.educationData.department.equals(dep) &&
                    student.educationData.yearOfStudy.equals(year) &&
                    student.educationData.group.equals(grp)) {
                System.out.println(student);
            }
        });
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "id=" + id +
                ", first name=" + personalData.firstName +
                ", last name=" + personalData.lastName +
                ", middle name=" + personalData.middleName +
                ", date of birth=" + dateFormat.format(personalData.dateOfBirth.getTime()) +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department=" + educationData.department +
                ", year of study=" + educationData.yearOfStudy +
                ", group=" + educationData.group;
    }
}
