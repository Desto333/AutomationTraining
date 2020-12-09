package Patient;

//3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
//Создать массив объектов. Вывести:
//a) список пациентов, имеющих данный диагноз;
//b) список пациентов, номер медицинской карты которых находится в заданном интервале.

import java.util.Arrays;

public class Patient {
    private static Patient[] listOfPatients = new Patient[5];

    private int id;
    private Person person;
    private MedicalInfo medicalInfo;

    public void addPatientToList() {
        listOfPatients[this.getId() - 1] = this;
    }

    public static void printPatientsWithDiagnosis(String diagnosis) {
        System.out.println("Patients with diagnosis: " + diagnosis);
        for (int i = 0; i < listOfPatients.length; i++) {
            if(listOfPatients[i].getMedicalInfo().getDiagnosis().equalsIgnoreCase(diagnosis)) {
                System.out.println(listOfPatients[i]);
            }
        }
    }

    public static void printPatientsWithMedicalCardsFromRange(int startRange, int finishRange) {
        System.out.println("Patients with medical cards from " + startRange + " to " + finishRange + " :");
        Arrays.stream(listOfPatients).filter(patient ->
                patient.getMedicalInfo().getMedicalCardNumber() >= startRange &&
                        patient.getMedicalInfo().getMedicalCardNumber() <= finishRange).forEach(System.out::println);
    }

    public Patient(int id, Person person, MedicalInfo medicalInfo) {
        this.id = id;
        this.person = person;
        this.medicalInfo = medicalInfo;
    }

    public Patient(int id, Person person) {
        this.id = id;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public MedicalInfo getMedicalInfo() {
        return medicalInfo;
    }

    static class Person{
        String secondName;
        String firstName;
        String middleName;
        String address;
        String phoneNumber;

        public Person(String secondName, String firstName, String middleName, String address, String phoneNumber) {
            this.secondName = secondName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public String getSecondName() {
            return secondName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    static class MedicalInfo {
        int medicalCardNumber;
        String diagnosis;

        public MedicalInfo(int medicalCardNumber, String diagnosis) {
            this.medicalCardNumber = medicalCardNumber;
            this.diagnosis = diagnosis;
        }

        public int getMedicalCardNumber() {
            return medicalCardNumber;
        }

        public String getDiagnosis() {
            return diagnosis;
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", person=" + person.getSecondName() + " " + person.getFirstName() + " " + person.getMiddleName() +
                " " + person.getAddress() + " " + person.getPhoneNumber() +
                ", medicalInfo=" + medicalInfo.getDiagnosis() + " " + medicalInfo.getMedicalCardNumber() +
                '}';
    }
}
