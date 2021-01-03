package port;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Port extends ArrayBlockingQueue<Ship> {

    private int numberOfContainers;
    private final int numberOfPierces;

    public Port(int numberOfPierces, int numberOfContainers) {
        super(numberOfPierces);
        this.numberOfContainers = numberOfContainers;
        this.numberOfPierces = numberOfPierces;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public int getNumberOfPierces() {
        return numberOfPierces;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    public void load(Ship ship) {
        System.out.println("Starting to load ship " + ship.getShipNumber()
                + " at " + Thread.currentThread().getName());
        while (ship.checkLoading()) {
            try {
                if (getNumberOfContainers() >= ship.getSize().getCargoCapacity()) {
                    ship.setCargoLoaded(ship.getCargoLoaded() + 10);
                    TimeUnit.MILLISECONDS.sleep(300);
                    setNumberOfContainers(getNumberOfContainers() - 10);
                    System.out.println("Ship " + ship.getShipNumber() + " got loaded 10 containers at "
                            + Thread.currentThread().getName() + ", now carries "
                            + ship.getCargoLoaded() + " containers.");
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Ship " + ship.getShipNumber()
                + " is fully loaded, now carries " + ship.getCargoLoaded() + " containers.");
        System.out.println("There are " + getNumberOfContainers() + " containers in the port.");
    }

    public void unload(Ship ship) {
        System.out.println("Starting to unload ship "
                + ship.getShipNumber() + " at " + Thread.currentThread().getName());
        while (ship.getCargoLoaded() != 0) {
            try {
                ship.setCargoLoaded(ship.getCargoLoaded() - 10);
                TimeUnit.MILLISECONDS.sleep(300);
                setNumberOfContainers(getNumberOfContainers() + 10);
                System.out.println("Ship " + ship.getShipNumber() + " got unloaded 10 containers at "
                        + Thread.currentThread().getName() + ", now carries "
                        + ship.getCargoLoaded() + " containers.");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Ship " + ship.getShipNumber()
                + " is fully unloaded, now carries " + ship.getCargoLoaded() + " containers.");
        System.out.println("There are " + getNumberOfContainers() + " containers in the port.");
    }

    public void unloadAndReload(Ship ship) {
        this.unload(ship);
        this.load(ship);
    }
}
