package newPort;

import java.util.concurrent.ArrayBlockingQueue;

public class Port extends ArrayBlockingQueue<Pierce> {

    private int numberOfContainers;
    private final int numberOfPierces;

    public Port(int numberOfPierces, int numberOfContainers) {
        super(numberOfPierces);
        this.numberOfContainers = numberOfContainers;
        this.numberOfPierces = numberOfPierces;
        createPiercesAtPort(numberOfPierces);
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    public void createPiercesAtPort(int numberOfPierces) {
        for (int i = 0; i < numberOfPierces; i++) {
            this.add(new Pierce());
        }
    }
}
