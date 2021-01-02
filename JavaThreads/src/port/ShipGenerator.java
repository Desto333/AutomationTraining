package port;

import java.util.concurrent.TimeUnit;

public class ShipGenerator implements Runnable {
    private final Port port;
    private final int numberOfShipsToGenerate;
    public static boolean stillHasWork = true;

    public ShipGenerator(Port port, int numberOfShipsToGenerate) {
        this.port = port;
        this.numberOfShipsToGenerate = numberOfShipsToGenerate;
    }

    @Override
    public void run() {
        int shipCount = 0;
        while (shipCount < numberOfShipsToGenerate) {
            Thread.currentThread().setName("\n" + "A new ship entering the port.");
            try {
                shipCount++;
                Ship ship = new Ship();
                port.put(ship);     // if port is full, ships wait for their turn
                System.out.println(Thread.currentThread().getName()
                        + " It's a " + ship.getSize() + " ship, number " + ship.getShipNumber()
                        + ", carrying " + ship.getCargoLoaded() + " containers.");
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.err.println("Problem while generating a ship." + Thread.currentThread().getName());
                System.err.println(e.getMessage());
            }
        }
        stillHasWork = false;
        Thread.currentThread().interrupt();
    }
}
