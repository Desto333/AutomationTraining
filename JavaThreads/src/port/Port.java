package port;

import java.util.concurrent.ArrayBlockingQueue;

public class Port extends ArrayBlockingQueue<Ship> {

    private volatile int numberOfContainers;
    private final int shipCapacity;

    public Port(int shipCapacity, int numberOfContainers) {
        super(shipCapacity);
        this.numberOfContainers = numberOfContainers;
        this.shipCapacity = shipCapacity;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }
}
