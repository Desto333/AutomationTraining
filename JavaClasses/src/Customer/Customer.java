package Customer;

// 2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
//Создать массив объектов. Вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.

import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    static Customer[] listOfCustomers = new Customer[5];

    int id;
    Person person;
    BankingInfo bankingInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BankingInfo getBankingInfo() {
        return bankingInfo;
    }

    public void setBankingInfo(BankingInfo bankingInfo) {
        this.bankingInfo = bankingInfo;
    }

    public Customer(int id, Person person, BankingInfo bankingInfo) {
        this.id = id;
        this.person = person;
        this.bankingInfo = bankingInfo;
    }

    public Customer(int id, BankingInfo bankingInfo) {
        this.id = id;
        this.bankingInfo = bankingInfo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", person=" + person.getSecondName() + " " + person.getFirstName() + " " +  person.getMiddleName() +
                ", address=" + person.getAddress() +
                ", bankingInfo=" + bankingInfo.getBankingAccountNumber() + " " + bankingInfo.getCreditCardNumber() +
                '}';
    }

    public void addCustomerToList() {
        listOfCustomers[this.getId() - 1] = this;
    }

    public static void printListOfCustomers() {
        Arrays.sort(listOfCustomers, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getPerson().getSecondName().compareTo(o2.getPerson().getSecondName());
            }
        });
        System.out.println(Arrays.toString(listOfCustomers));
    }

    public static void printListOfCustomersWithinCreditCardNumberRange(String startRange, String finishRange) {
        for (int i = 0; i < listOfCustomers.length; i++) {
            if(Long.parseLong(listOfCustomers[i].getBankingInfo().getCreditCardNumber()) >= Long.parseLong(startRange) &&
                    Long.parseLong(listOfCustomers[i].getBankingInfo().getCreditCardNumber()) <= Long.parseLong(finishRange)) {
                System.out.println(listOfCustomers[i]);
            }
        }
    }

    public static class Person {
        String secondName;
        String firstName;
        String middleName;
        String address;

        public Person(String secondName, String firstName, String middleName, String address) {
            this.secondName = secondName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.address = address;
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
    }

    public static class BankingInfo{
        String creditCardNumber;
        String bankingAccountNumber;

        public BankingInfo(String creditCardNumber, String bankingAccountNumber) {
            this.creditCardNumber = creditCardNumber;
            this.bankingAccountNumber = bankingAccountNumber;
        }

        public String getCreditCardNumber() {
            return creditCardNumber;
        }

        public String getBankingAccountNumber() {
            return bankingAccountNumber;
        }
    }

}
