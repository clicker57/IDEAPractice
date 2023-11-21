package single;

public class SingleHungry {
    private String id;

    private static SingleHungry single = new SingleHungry();

    private SingleHungry(){}

    public static SingleHungry getInstance() {
        return single;
    }
}
