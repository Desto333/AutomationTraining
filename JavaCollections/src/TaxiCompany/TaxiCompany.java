package TaxiCompany;

import java.util.ArrayList;

public class TaxiCompany {
    private ArrayList<Automobile> listOfCars = new ArrayList<>();

    public ArrayList<Automobile> getListOfCars() {
        return listOfCars;
    }

    public void setListOfCars(ArrayList<Automobile> listOfCars) {
        this.listOfCars = listOfCars;
    }
}
