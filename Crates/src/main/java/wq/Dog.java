package wq;

public class Dog extends Animal {
    @Override
    void cry() {
        System.out.println("wang wang wang!");
    }

    @Override
    String getAnimalName() {
        return this.getClass().getSimpleName();
    }
}
