package day08;

import day08.exercise1.Director;
import day08.exercise1.Manager;
import org.junit.Test;

public class PackageTest {
    @Test
    public void test0() {
        Director d1 = new Director("Alice", 20000, "Garden Street 2711", 3, 1000);
        d1.show();

        Manager m1 = new Manager("Black", 10000, "Baker Street 1601", 5, "Sales");
        m1.show();
    }
}
