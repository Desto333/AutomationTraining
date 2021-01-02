package port;

import java.util.Random;

public class Ship {
    static Random random = new Random();
    private static int counter = 0;
    private final int shipNumber = ++counter;
    private int cargoLoaded;
    private final ShipSize size;
    private final boolean needsReloading;

    public Ship() {
        this.size = getRandomShipSize();
        this.cargoLoaded = random.nextBoolean() ? size.getCargoCapacity() : 0;
        this.needsReloading = random.nextBoolean();
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public ShipSize getSize() {
        return size;
    }

    public boolean needsReloading() {
        return needsReloading;
    }

    public int getCargoLoaded() {
        return cargoLoaded;
    }

    public void setCargoLoaded(int cargoLoaded) {
        this.cargoLoaded = cargoLoaded;
    }

    public boolean checkLoading() {
        return cargoLoaded < size.getCargoCapacity();
    }

    public ShipSize getRandomShipSize() {
        return switch (random.nextInt(3)) {
            case 0 -> ShipSize.SMALL;
            case 1 -> ShipSize.MIDDLE;
            default -> ShipSize.LARGE;
        };
    }

}
