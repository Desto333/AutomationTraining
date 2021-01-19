package newPort;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ship extends Thread {
    static Random random = new Random();
    private static int counter = 0;
    private final int shipNumber = ++counter;
    private final String shipName;
    private int cargoLoaded;
    private final ShipSize size;
    private final boolean needsReloading;
    private final Port port;

    public Ship(Port port) {
        this.port = port;
        this.size = getRandomShipSize();
        this.cargoLoaded = random.nextBoolean() ? size.getCargoCapacity() : 0;
        this.needsReloading = random.nextBoolean();
        this.shipName = "ship" + getShipNumber();
        start();
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

    public String getShipName() {
        return shipName;
    }

    public ShipSize getRandomShipSize() {
        return switch (random.nextInt(3)) {
            case 0 -> ShipSize.SMALL;
            case 1 -> ShipSize.MIDDLE;
            default -> ShipSize.LARGE;
        };
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
            Pierce pierce = port.take();
            System.out.println(this.getShipName() + " arrives at " + pierce.getName());
            if (this.getCargoLoaded() == 0) {
                this.getLoaded(pierce);
            } else {
                if (this.needsReloading()) {
                    this.getReloaded(pierce);
                } else {
                    this.getUnloaded(pierce);
                }
            }
            System.out.println(this.getShipName() + " is leaving " + pierce.getName());
            port.add(pierce);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getLoaded(Pierce pierce) {
        System.out.println("Starting to load ship " + this.getShipName()
                + " at " + pierce.getName());
        while (this.checkLoading()) {
            try {
                if (port.getNumberOfContainers() >= this.getSize().getCargoCapacity()) {
                    this.setCargoLoaded(this.getCargoLoaded() + 10);
                    TimeUnit.MILLISECONDS.sleep(300);
                    port.setNumberOfContainers(port.getNumberOfContainers() - 10);
                    System.out.println(this.getShipName() + " got loaded 10 containers at "
                            + pierce.getName() + ", now carries "
                            + this.getCargoLoaded() + " containers.");
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(this.getShipName() + " is fully loaded, now carries "
                + this.getCargoLoaded() + " containers.");
        System.out.println("There are " + port.getNumberOfContainers() + " containers in the port.");
    }

    public void getUnloaded(Pierce pierce) {
        System.out.println("Starting to unload " + this.getShipName() + " at " + pierce.getName());
        while (this.getCargoLoaded() != 0) {
            try {
                this.setCargoLoaded(this.getCargoLoaded() - 10);
                TimeUnit.MILLISECONDS.sleep(300);
                port.setNumberOfContainers(port.getNumberOfContainers() + 10);
                System.out.println(this.getShipName() + " got unloaded 10 containers at " + pierce.getName()
                        + ", now carries " + this.getCargoLoaded() + " containers.");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(this.getShipName() + " is fully unloaded, now carries "
                + this.getCargoLoaded() + " containers.");
        System.out.println("There are " + port.getNumberOfContainers() + " containers in the port.");
    }

    public void getReloaded(Pierce pierce) {
        this.getUnloaded(pierce);
        this.getLoaded(pierce);
    }
}
