package wq;

public class Simulator {
    public void playSound(Animal animal) {
        System.out.print(animal.getAnimalName() + " is crying : ");
        animal.cry();
    }
}
