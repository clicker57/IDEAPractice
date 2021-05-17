package practice.generics;

public class Apple extends Fruit {
    private final String type = "apple";

    public Apple() {
    }

    public Apple(String name, Double price) {
        super(name, price);
    }

    public String getType() {
        return type;
    }

}
