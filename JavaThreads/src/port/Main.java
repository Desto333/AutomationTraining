package port;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Port port = new Port(3, 1000);
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new ShipGenerator(port, 15));

        for (int i = 0; i < port.getNumberOfPierces(); i++) {
            exec.execute(new Pierce(port));
        }

        exec.shutdown();
    }
}
