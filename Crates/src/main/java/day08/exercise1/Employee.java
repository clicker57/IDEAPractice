package day08.exercise1;

public abstract class Employee {
    /**
     * 姓名
     */
    protected String name;
    /**
     * 基本工资
     */
    protected double baseSalary;
    /**
     * 家庭住址
     */
    protected String homeAddress;
    /**
     * 该月休假数（天）
     */
    protected int offDaysOfMonth;

    public Employee(String name, double baseSalary, String homeAddress, int offDaysOfMonth) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.homeAddress = homeAddress;
        this.offDaysOfMonth = offDaysOfMonth;
    }

    public Employee() {
    }

    /**
     * 显示信息
     */
    public void show() {
        System.out.println(this.toString());
    }

    /**
     * 按休假天数计算需扣除的费用
     *
     * @return 需扣除的费用
     */
    public double calculateLessPay() {
        if (offDaysOfMonth <= 5) {
            return baseSalary / 4;
        } else {
            return baseSalary / 2;
        }
    }

    /**
     * 计算工资总额
     *
     * @return
     */
    public abstract double calculateTotal();

    @Override
    public String toString() {
        return "The employee's basic info : " +
                "name=" + name +
                ", baseSalary=" + baseSalary +
                ", homeAddress=" + homeAddress +
                ", offDaysOfMonth=" + offDaysOfMonth +
                '}';
    }
}
