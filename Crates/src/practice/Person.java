package practice;

/**
 * Created by Philip on 10/19/16.
 *
 * String n : person's name
 */
public abstract class Person {
    private String name;

    public Person(String n) {
        name = n;
    }

    public abstract String getDiscription();

    public String getName()
    {
        return name;
    }
}
