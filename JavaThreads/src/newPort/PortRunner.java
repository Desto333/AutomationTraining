package newPort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortRunner {
    public static void main(String[] args) {
        Port port = new Port(3, 1000);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ShipGenerator(port, 10));
        exec.shutdown();
    }
}
