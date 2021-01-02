package port;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Port port = new Port(3, 1000);      // shipCapacity - number of pierces available
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= port.getShipCapacity(); i++) {
            try {
                executorService.submit(new Pierce(port));
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("Problem while creating pierce threads");
                System.err.println(e.getMessage());
            }
        }

        ShipGenerator shipGenerator = new ShipGenerator(port, 15);

        executorService.submit(shipGenerator);

        executorService.shutdown();
    }
}
