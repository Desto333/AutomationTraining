package port;

import java.util.concurrent.TimeUnit;

public class Pierce implements Runnable {
    private static int counter = 0;
    private final int pierceNumber = ++counter;
    private Port port;

    public Pierce(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Pierce " + pierceNumber);
                TimeUnit.MILLISECONDS.sleep(10);
                Ship ship = port.take();
                if (ship.getCargoLoaded() == 0) {
                    load(ship);
                } else {
                    if (ship.needsReloading()) {
                        unloadAndReload(ship);
                    } else {
                        unload(ship);
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("Problem while letting ship into port." + Thread.currentThread().getName());
                System.err.println(e.getMessage());
            }
        }
    }

    public void load(Ship ship) {
        System.out.println("\n" + "Starting to load ship " + ship.getShipNumber()
                + " at " + Thread.currentThread().getName());
        System.out.println();
        while (ship.checkLoading()) {
            try {
                if (port.getNumberOfContainers() >= ship.getSize().getCargoCapacity()) {
                    TimeUnit.MILLISECONDS.sleep(30);
                    ship.setCargoLoaded(ship.getCargoLoaded() + 10);
                    port.setNumberOfContainers(port.getNumberOfContainers() - 10);
                    System.out.print("\n" + "Ship " + ship.getShipNumber()
                            + " got loaded 10 containers and now carries " + ship.getCargoLoaded() + " containers.");
                    System.out.println(" There are " + port.getNumberOfContainers() + " containers in the port.");
                }
            } catch (InterruptedException e) {
                System.err.println("Problem while loading the ship.");
                System.err.println(e.getMessage());
            }
        }
        System.out.print("\n" + "Ship " + ship.getShipNumber()
                + " is fully loaded, now carries " + ship.getCargoLoaded() + " containers. ");
        System.out.println(" There are " + port.getNumberOfContainers() + " containers in the port." + "\n");
    }

    public void unload(Ship ship) {
        System.out.println("\n" + "Starting to unload ship "
                + ship.getShipNumber() + " at " + Thread.currentThread().getName());
        System.out.println();
        while (ship.getCargoLoaded() != 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
                ship.setCargoLoaded(ship.getCargoLoaded() - 10);
                port.setNumberOfContainers(port.getNumberOfContainers() + 10);
                System.out.print("Ship " + ship.getShipNumber() + " got unloaded 10 containers and now carries "
                        + ship.getCargoLoaded() + " containers.");
                System.out.println(" There are " + port.getNumberOfContainers() + " containers in the port.");
            } catch (InterruptedException e) {
                System.err.println("Problem while unloading the ship.");
                System.err.println(e.getMessage());
            }
        }
        System.out.print("\n" + "Ship " + ship.getShipNumber()
                + " is fully unloaded, now carries " + ship.getCargoLoaded() + " containers. ");
        System.out.println(" There are " + port.getNumberOfContainers() + " containers in the port." + "\n");
    }

    public void unloadAndReload(Ship ship) {
        this.unload(ship);
        this.load(ship);
    }
}
