package practice;

import java.util.Random;

/**
 * Created by Philip on 10/11/16.
 */
public class Employee implements Comparable<Employee>, Cloneable {
    private static int nextId;

    private String name="";
    private double salary;
    private int id;

    // static initialization block
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    // three overloaded constructions
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        // calls the practice.Employee(String, double) constructor
        this("practice.Employee #" + nextId, s);
    }

    public Employee() {
        // name initialized to ""
        // salary initialized to 0
        // id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
