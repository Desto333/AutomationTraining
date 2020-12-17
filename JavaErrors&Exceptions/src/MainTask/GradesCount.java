package MainTask;

public class GradesCount {
    public static void calculateAverageGradeForStudent(Student student) {
        System.out.println("Average grade of " + student.getStudentName() + " is: "
                + student.getSubjects().values().stream().mapToDouble(Integer::intValue).average().getAsDouble());
        System.out.println();
    }

    public static void calculateAverageGradeForSubjectAtGroup(String subject, Group group) {
        System.out.println("Average grade of group " + group.getGroupName() + " for " + subject + " is: "
                + group.getListOfStudents().stream().mapToDouble(student -> student.getSubjects().get(subject))
                .average().getAsDouble());
        System.out.println();
    }

    public static void calculateAverageGradeForSubjectAtUniversity(String subject, University university) {
        long sumOfGrades = 0;
        long numberOfStudents = 0;
        for (Department department : university.getListOfDepartments()) {
            for (Group group : department.getListOfGroups()) {
                for (Student student : group.getListOfStudents()) {
                    if (student.getSubjects().containsKey(subject)) {
                        sumOfGrades += student.getSubjects().get(subject);
                        numberOfStudents++;
                    }
                }
            }
        }

        if (numberOfStudents != 0) {
            System.out.println("Average grade for " + subject + " at " + university.getUniversityName() + " is: "
                    + (double) sumOfGrades / numberOfStudents);
        } else {
            System.out.println("Nobody studies " + subject + " at " + university.getUniversityName());
        }
    }
}
