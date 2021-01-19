package newPort;

public class Pierce {
    String name;
    private static int counter = 0;
    private final int pierceNumber = ++counter;

    public Pierce() {
        this.name = "Pierce" + getPierceNumber();
        System.out.println(this.name + " is ready to work!");
    }

    public String getName() {
        return name;
    }

    public int getPierceNumber() {
        return pierceNumber;
    }
}
