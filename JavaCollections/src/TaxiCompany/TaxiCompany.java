package TaxiCompany;

import java.util.ArrayList;

public class TaxiCompany {
    private ArrayList<Automobile> listOfCars = new ArrayList<Automobile>() {
        {
            add(new PassengerCar("VolkswagenPolo", 13000, 7, 170, 4, PassengerCarClass.Regular));
            add(new PassengerCar("KiaRio", 12500, 8, 168, 4, PassengerCarClass.Regular));
            add(new PassengerCar("HyundaiSolaris", 12300, 8, 165, 4, PassengerCarClass.Regular));
            add(new PassengerCar("LadaLargus", 11000, 10, 150, 6, PassengerCarClass.Economy));
            add(new PassengerCar("LadaVesta", 13000, 9, 160, 4, PassengerCarClass.Regular));
            add(new PassengerCar("SkodaRapid", 13500, 7, 170, 4, PassengerCarClass.Regular));
            add(new PassengerCar("SkodaOctavia", 15000, 8, 180, 4, PassengerCarClass.Regular));
            add(new PassengerCar("BMW530", 40000, 11, 250, 4, PassengerCarClass.Luxury));
        }
    };

    public ArrayList<Automobile> getListOfCars() {
        return listOfCars;
    }
}
