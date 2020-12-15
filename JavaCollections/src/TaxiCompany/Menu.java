package TaxiCompany;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    TaxiCompany taxiCompany = new TaxiCompany();

    public void start() {
        while (true) {
            System.out.println("Please, make your choice what to do (numbers 1-4): " + "\n" +
                    "- Press 1 to display total cost of all cars in the company." + "\n" +
                    "- Press 2 to sort company's cars by their fuel consumption." + "\n" +
                    "- Press 3 to find cars within defined speed limit range." + "\n" +
                    "- Press 4 to read list of cars from file." + "\n" +
                    "- Press 5 to write list of cars to file." + "\n" +
                    "- Press 6 to exit the program.");

            try {
                switch (scanner.nextInt()) {
                    case 1: {
                        calculateTotalCostOfAllCars();
                        break;
                    }
                    case 2: {
                        sortListOfCarsByFuelConsumption();
                        break;
                    }
                    case 3: {
                        findCarsWithinSpeedLimit();
                        break;
                    }
                    case 4: {
                        readListOfCarsFromFile();
                        break;
                    }
                    case 5: {
                        writeListOfCarsToFile();
                        break;
                    }
                    case 6: {
                        return;
                    }
                    default: {
                        System.out.println("Please, make correct choice (numbers 1-4)!!!");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, make correct choice (numbers 1-4)!!!");
            }
        }
    }

    public void calculateTotalCostOfAllCars() {
        System.out.println("\n" + "Total cost of all cars is: "
                + taxiCompany.getListOfCars().stream().mapToInt(car -> car.getPrice()).sum() + "\n");
    }

    public void sortListOfCarsByFuelConsumption() {
        taxiCompany.getListOfCars().sort((Comparator<Automobile>)
                (o1, o2) -> o1.getFuelConsumptionPer100km() - o2.getFuelConsumptionPer100km());
        taxiCompany.getListOfCars().forEach(System.out::println);
        System.out.println();
    }

    public void findCarsWithinSpeedLimit() {
        try {
            System.out.println("Please, enter lower speed limit");
            int lowerKmPerHour = scanner.nextInt();
            System.out.println("Please, enter upper speed limit");
            int upperKmPerHour = scanner.nextInt();
            taxiCompany.getListOfCars().stream().filter(car -> (car.getMaxSpeed() > lowerKmPerHour)
                    && (car.getMaxSpeed() < upperKmPerHour)).forEach(System.out::println);
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Please, enter correct speed limits!!!");
        }
    }

    public void writeListOfCarsToFile() {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter("src\\TaxiCompany\\taxiCompany1.dat"))) {
            for (int i = 0; i < taxiCompany.getListOfCars().size(); i++) {
                bufferedWriter.write(taxiCompany.getListOfCars().get(i).toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readListOfCarsFromFile() {
        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader("src\\TaxiCompany\\taxiCompany1.dat"))) {
            String car;
            ArrayList<Automobile> updatedListOfCars = new ArrayList<>();
            while ((car = bufferedReader.readLine()) != null) {
                String[] carArray = car.split("\\s(\\w+)=");
                updatedListOfCars.add(new PassengerCar(carArray[1], Integer.parseInt(carArray[2])
                        , Integer.parseInt(carArray[3]), Integer.parseInt(carArray[4]), Integer.parseInt(carArray[5])
                        , PassengerCarClass.valueOf(carArray[6])));
            }
            taxiCompany.setListOfCars(updatedListOfCars);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
