package port;

import java.util.concurrent.TimeUnit;

public class Pierce implements Runnable {
    private static int counter = 0;
    private final int pierceNumber = ++counter;
    private final Port port;

    public Pierce(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Pierce " + pierceNumber);
        while (true) {
            Ship ship;
            try {
                ship = port.poll(5, TimeUnit.SECONDS);
                if (ship != null) {
                    if (ship.getCargoLoaded() == 0) {
                        port.load(ship);
                    } else {
                        if (ship.needsReloading()) {
                            port.unloadAndReload(ship);
                        } else {
                            port.unload(ship);
                        }
                    }
                } else {
                    System.out.println("\n" + "Pierce " + pierceNumber + " stops working." + "\n");
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("\n" + "Pierce " + pierceNumber + " stops working." + "\n");
                break;
            }
        }
    }
}
