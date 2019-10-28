package practice;

/**
 * Created by Philip on 7/22/16.
 */
public class Manager extends Employee {
    private double bonus;

    private Long lastSpend;

    public Long getLastSpend() {
        return lastSpend;
    }

    public void setLastSpend(Long lastSpend) {
        this.lastSpend = lastSpend;
    }

    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", lastSpend=" + lastSpend +
                '}';
    }
}
