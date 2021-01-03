package port;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShipGenerator implements Runnable {
    private final Port port;
    private final int numberOfShipsToGenerate;
    Random random = new Random();


    public ShipGenerator(Port port, int numberOfShipsToGenerate) {
        this.port = port;
        this.numberOfShipsToGenerate = numberOfShipsToGenerate;
    }

    @Override
    public void run() {
        int shipCount = 0;
        Thread.currentThread().setName("A new ship is waiting outside the port.");
        while (shipCount < numberOfShipsToGenerate) {
            try {
                Ship ship = new Ship();
                System.out.println(Thread.currentThread().getName()
                        + " It's a " + ship.getSize() + " ship " + ship.getShipNumber()
                        + ", carrying " + ship.getCargoLoaded() + " containers.");
                shipCount++;
                port.put(ship);
                TimeUnit.SECONDS.sleep(random.nextInt(3));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("\n" + "Ship Generator stops working" + "\n");
    }
}
