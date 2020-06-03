package day08.exercise1;

public class Director extends Employee {
    /**
     * 交通补助
     */
    private double transportAllowance;

    public Director(String name, double baseSalary, String homeAddress, int offDaysOfMonth, double transportAllowance) {
        super(name, baseSalary, homeAddress, offDaysOfMonth);
        this.transportAllowance = transportAllowance;
    }

    /**
     * 计算董事长的总工资
     *
     * @return
     */
    @Override
    public double calculateTotal() {
        return this.baseSalary + 5000 + this.transportAllowance;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("The Director's total salary is : " + calculateTotal());
        System.out.println("The Director's actual salary is : " + (calculateTotal() - calculateLessPay()));
    }

    protected void payForVacation(double amount) {
        System.out.println(name + " always pays " + amount + " for vacation annually.");
    }
}
