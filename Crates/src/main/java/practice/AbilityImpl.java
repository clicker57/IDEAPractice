package practice;

import java.io.IOException;

public class AbilityImpl implements Ability {
    @Override
    public void flyAway() throws IOException {
        System.out.println(this.getClass().getSimpleName() + " can fly now.");
    }

    public void show() {
        System.out.println("This is an implementation.");
    }
}
