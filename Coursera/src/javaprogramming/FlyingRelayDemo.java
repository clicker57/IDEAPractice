package javaprogramming;

/**
 * description: Flying relay with random aircrafts.
 *              Practise with class, abstract class, interface,
 *              setter/getter, static, final,
 *              abstract, Override
 * file-encoding: UTF-8
 * Created by hockidoggy on 11/07/2017.
 */
public class FlyingRelayDemo {
    private final static String[] names = {"Roc", "Swift", "Nuclear", "Eagle", "Duke", "ShootingStar", "Hurricane"};

    public static void main(String[] args) {
        Aircraft[] allFlyers = new Aircraft[5];

        // create aircrafts randomly
        for (int i = 0; i < allFlyers.length; i++) {
            double rand = Math.random();
            Aircraft craft = null;
            switch ((int)(rand * 3)) {
                case 0:
                    craft = new UAV(names[(int)(rand * 7)] + i, rand * 10);
                    break;
                case 1:
                    craft = new HotBalloon(names[(int)(rand * 7)] + i, "hydrogen fuel");
                    break;
                case 2:
                    craft = new ModelPlane(names[(int)(rand * 7)] + i);
                    break;
            }
            allFlyers[i] = craft;
        }

        System.out.println("~~~~~~~~~ show time ~~~~~~~~~");
        // let all the aircrafts fly in turns
        for (Aircraft ac: allFlyers) {
            if (ac instanceof Flying) {
                ((Flying) ac).flyAhead(ac.getNumber());
            } else {
                System.out.println("No. " + ac.getNumber() + " can not fly. What a pity!");
            }
            ac.checkState();
        }
    }
}

abstract class Aircraft {
    private static int serial = 1;

    private String name;
    private String power;
    private double speed;
    private int number;

    void setPower(String power) {
        this.power = power;
    }

    void setSpeed(double speed) {
        this.speed = speed;
    }

    String getPower() {
        return power;
    }

    double getSpeed() {
        return speed;
    }

    int getNumber() {
        return number;
    }

    String getName() {
        return name;
    }

    // constructor
    Aircraft(String name) {
        this.name = name;
        this.number = serial++;
    }

    // show the state of aircraft
    abstract void checkState();
}

interface Flying{
    /**
     * To show how far the flyer of specific number flies.
     * @param n the serial number of each flyer
     */
    void flyAhead(int n);
}

class UAV extends Aircraft implements Flying {

    UAV(String name, double speed) {
        super(name);
        setSpeed(speed);
        System.out.println("UAV No. " + this.getNumber() + " : " + this.getName() + " starts up.");
    }

    @Override
    public void flyAhead(int number) {
        int DISTANCE_FACTOR = 10;
        double distance = Math.random() * DISTANCE_FACTOR;
        System.out.println("UAV No. " + this.getNumber() + " flies about " + distance + " meters.");
    }

    @Override
    void checkState() {
        System.out.println("UAV is in best condition.");
    }
}

class HotBalloon extends Aircraft implements Flying {

    HotBalloon(String name, String power) {
        super(name);
        setPower(power);
        System.out.println("HotBalloon No. " + this.getNumber() + " : " + this.getName() + " with power " + this.getPower() + " comes into the sky.");
    }

    @Override
    public void flyAhead(int number) {
        int DISTANCE_FACTOR = 2;
        double distance = Math.random() * DISTANCE_FACTOR;
        System.out.println("HotBalloon No. " + this.getNumber() + " floats about " + distance + " meters.");
    }

    @Override
    void checkState() {
        System.out.println("HotBalloon is big. HotBalloon is high.");
    }
}

class ModelPlane extends Aircraft implements Flying {

    ModelPlane(String name) {
        super(name);
        System.out.println("ModelPlane No. " + this.getNumber() + " : " + this.getName() + " is ready to launch.");
    }

    @Override
    void checkState() {
        System.out.println("ModelPlane is on board. Who want a race?");
    }

    @Override
    public void flyAhead(int number) {
        int DISTANCE_FACTOR = 100;
        double distance = Math.random() * DISTANCE_FACTOR;
        System.out.println("ModelPlane No. " + this.getNumber() + " runs about " + distance + " meters.");
    }
}
