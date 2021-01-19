package newPort;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShipGenerator implements Runnable {
    private final Port port;
    private final int numberOfShipsToGenerate;

    public ShipGenerator(Port port, int numberOfShipsToGenerate) {
        this.port = port;
        this.numberOfShipsToGenerate = numberOfShipsToGenerate;
    }

    @Override
    public void run() {
        int shipCount = 0;
        while (shipCount < numberOfShipsToGenerate) {
            try {
                Ship ship = new Ship(port);
                System.out.println("A new ship is approaching the port. It's a " + ship.getSize()
                        + " ship" + ship.getShipNumber() + ", carrying " + ship.getCargoLoaded() + " containers.");
                shipCount++;
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("\n" + "Ship Generator stops working" + "\n");
    }
}
