package day08.exercise2;

public class Laptop implements Elec, Net {
    private boolean powerStatus = false;

    private String netType = "wifi";

    public boolean on() {
        if (!powerStatus) {
            System.out.println("The laptop is starting up.");
            powerStatus = true;
        }
        return powerStatus;
    }

    public boolean off() {
        if (powerStatus) {
            System.out.println("The laptop is shutting down.");
            powerStatus = false;
        }
        return powerStatus;
    }

    public String getInterNet() {
        return netType;
    }
}
