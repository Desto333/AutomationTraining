package TaxiCompany;

public class PassengerCar extends Automobile {
    private int passengerCapacity;
    private PassengerCarClass passengerCarClass;

    public PassengerCar(String model, int price, int fuelConsumptionPer100km, int maxSpeed, int passengerCapacity, PassengerCarClass passengerCarClass) {
        super(model, price, fuelConsumptionPer100km, maxSpeed);
        this.passengerCapacity = passengerCapacity;
        this.passengerCarClass = passengerCarClass;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public PassengerCarClass getPassengerCarClass() {
        return passengerCarClass;
    }

    public void setPassengerCarClass(PassengerCarClass passengerCarClass) {
        this.passengerCarClass = passengerCarClass;
    }

    @Override
    public String toString() {
        return " model=" + this.getModel() +
                " price=" + this.getPrice() +
                " fuelConsumptionPer100km=" + this.getFuelConsumptionPer100km() +
                " maxSpeed=" + this.getMaxSpeed() +
                " passengerCapacity=" + passengerCapacity +
                " passengerCarClass=" + passengerCarClass;
    }
}
