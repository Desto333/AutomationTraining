package port;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pierce implements Runnable {
    private static int counter = 0;
    private final int pierceNumber = ++counter;
    private final Port port;
    ReentrantLock reentrantLock;
    Condition condition;

    public Pierce(Port port) {
        this.port = port;
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
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
