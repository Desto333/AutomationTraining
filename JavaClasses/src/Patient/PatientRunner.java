package Patient;

public class PatientRunner {
    public static void main(String[] args) {
        Patient.Person person1 = new Patient.Person("Ivanov", "Ivan", "Ivanovich", "Minsk", "5556677");
        Patient.Person person2 = new Patient.Person("Petrov", "Petr", "Petrovich", "Vitebsk", "7894512");
        Patient.Person person3 = new Patient.Person("Sidorov", "Sidor", "Sidorovich", "Gomel", "6543247");
        Patient.Person person4 = new Patient.Person("Sergeev", "Sergei", "Sergeevich", "Brest", "7895241");
        Patient.Person person5 = new Patient.Person("Igorev", "Igor", "Igorevich", "Grodno", "6985214");

        Patient patient1 = new Patient(1, person1, new Patient.MedicalInfo(10001, "Flu"));
        Patient patient2 = new Patient(2, person2, new Patient.MedicalInfo(10002, "Toothache"));
        Patient patient3 = new Patient(3, person3, new Patient.MedicalInfo(10003, "Headache"));
        Patient patient4 = new Patient(4, person4, new Patient.MedicalInfo(10004, "Pertussis"));
        Patient patient5 = new Patient(5, person5, new Patient.MedicalInfo(10005, "Tuberculosis"));

        patient1.addPatientToList();
        patient2.addPatientToList();
        patient3.addPatientToList();
        patient4.addPatientToList();
        patient5.addPatientToList();

        Patient.printPatientsWithDiagnosis("headache");
        System.out.println();
        Patient.printPatientsWithMedicalCardsFromRange(10002, 10004);

    }
}
