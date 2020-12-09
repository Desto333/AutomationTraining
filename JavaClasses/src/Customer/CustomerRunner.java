package Customer;

public class CustomerRunner {
    public static void main(String[] args) {
        Customer.Person person1 = new Customer.Person("Ivanov", "Ivan", "Ivanovich", "Minsk");
        Customer.Person person2 = new Customer.Person("Petrov", "Petr", "Petrovich", "Vitebsk");
        Customer.Person person3 = new Customer.Person("Sidorov", "Sidor", "Sidorovich", "Gomel");
        Customer.Person person4 = new Customer.Person("Sergeev", "Sergei", "Sergeevich", "Brest");
        Customer.Person person5 = new Customer.Person("Igorev", "Igor", "Igorevich", "Grodno");

        Customer customer1 = new Customer(1, person1, new Customer.BankingInfo("1111111111111111", "3013029680014"));
        customer1.addCustomerToList();
        Customer customer2 = new Customer(2, person2, new Customer.BankingInfo("2222222222222222", "3013029680015"));
        customer2.addCustomerToList();
        Customer customer3 = new Customer(3, person3, new Customer.BankingInfo("3333333333333333", "3013029680016"));
        customer3.addCustomerToList();
        Customer customer4 = new Customer(4, person4, new Customer.BankingInfo("4444444444444444", "3013029680017"));
        customer4.addCustomerToList();
        Customer customer5 = new Customer(5, person5, new Customer.BankingInfo("5555555555555555", "3013029680019"));
        customer5.addCustomerToList();



        Customer.printListOfCustomers();
        System.out.println();
        Customer.printListOfCustomersWithinCreditCardNumberRange("1100000011111111", "4400000044444444");
    }
}
