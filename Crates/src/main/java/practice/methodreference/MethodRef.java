package practice.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodRef {
    public static void main(String[] args) {
        Someone p1 = new Someone("Alice");
        Someone p2 = new Someone("Bob");
        Someone p3 = new Someone("Cathy");
        List<Someone> list = Arrays.asList(p1, p2);
        System.out.println("(x) -> Someone.sayHi(x)");
        list.forEach(Someone::sayhi); // (x) -> Someone.sayHi(x)
        System.out.println("(x) -> x.total()");
        list.forEach(Someone::total); // (x) -> x.total()
        System.out.println("(x) -> x.sayBye()");
        list.forEach(Someone::sayBye); // (x) -> x.sayBye()
        System.out.println("(x) -> p3.sayByeTo(x)");
        list.forEach(p3::sayByeTo); // (x) -> p3.sayByeTo(x)

        System.out.println("method ref to constructor ---->");
        Someone p4 = Someone.create("Dota", Someone::new);
        p4.sayBye();
    }
}

class Someone {
    private static int sum = 0;
    private String name;

    public Someone() {}

    public Someone(String name) {
        this.name = name;
        Someone.sum++;
    }

    // 静态，有参
    public static void sayhi(Someone person) {
        System.out.println(person.name + " say hi.");
    }

    // 非静态，无参
    public void total() {
        System.out.println("Sum : " + Someone.sum);
    }

    // 实例方法，非静态，无参
    public void sayBye() {
        System.out.println(this.name + " say bye.");
    }

    // 实例方法，非静态，有参
    public void sayByeTo(Someone p) {
        System.out.println(this.name + " say bye to " + p.name);
    }

    // 验证引用构造方法
    /**
     * 该方法中的Supplier接口是一个函数式接口，
     * 可以近似认为是一个专供函数式编程（此处暂时缩小范围为：方法引用中的“构造引用”）使用的工厂方法。
     *
     * @param name
     * @param supplier
     * @return
     */
    public static Someone create(String name, Supplier<Someone> supplier) {
        Someone one = supplier.get();
        one.name = name;
        return one;
    }
}