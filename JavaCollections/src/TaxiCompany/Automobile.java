package TaxiCompany;

public class Automobile {
    private String model;
    private int price;
    private int fuelConsumptionPer100km;
    private int maxSpeed;

    public Automobile(String model, int price, int fuelConsumptionPer100km, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFuelConsumptionPer100km() {
        return fuelConsumptionPer100km;
    }

    public void setFuelConsumptionPer100km(int fuelConsumptionPer100km) {
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
