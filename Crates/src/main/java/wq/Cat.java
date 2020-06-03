package wq;

public class Cat extends Animal {
    @Override
    void cry() {
        System.out.println("Meow Meow Meow!");
    }

    @Override
    String getAnimalName() {
        return this.getClass().getSimpleName();
    }
}
