package newPort;

public enum ShipSize {
    SMALL(20), MIDDLE(50), LARGE(80);

    private final int cargoCapacity;

    ShipSize(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }
}
