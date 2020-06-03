package day08.exercise1;

public class Manager extends Employee {
    /**
     * 部门
     */
    private String department;

    public Manager(String name, double baseSalary, String homeAddress, int offDaysOfMonth, String department) {
        super(name, baseSalary, homeAddress, offDaysOfMonth);
        this.department = department;
    }

    /**
     * 计算部门经理的工资总额
     *
     * @return
     */
    @Override
    public double calculateTotal() {
        return baseSalary + 1500 + baseSalary * 0.20;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("The department is " + department);
        System.out.println("The department manager's total salary is : " + calculateTotal());
        System.out.println("The department manager's actual salary is : " + (calculateTotal() - calculateLessPay()));
    }
}
