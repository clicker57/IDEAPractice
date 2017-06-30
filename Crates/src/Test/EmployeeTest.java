package Test;

import practice.Employee;
import practice.Manager;

import static org.junit.Assert.*;

/**
 * Created by Philip on 10/11/16.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee(600000);
        staff[2] = new Employee();

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }

        Manager[] managers = new Manager[3];
        Employee[] newStaff = managers;
//        newStaff[0] = new Employee("haha", 1000);
        managers[0] = new Manager("none",1.00);
        managers[0].setBonus(1000);

        if (staff[0] instanceof Cloneable) {
            System.out.println("staff[0] Cloneable");
        } else {
            System.out.println("not Cloneable");
        }
    }

}