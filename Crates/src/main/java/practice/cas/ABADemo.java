package practice.cas;

import java.util.concurrent.atomic.AtomicReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        System.out.println("==========以下是ABA问题的产生===========");
        new Thread(() -> {
            System.out.println(atomicReference.compareAndSet(100, 128));
            System.out.println(atomicReference.get());
            System.out.println(atomicReference.compareAndSet(128, 100));
            System.out.println(atomicReference.get());
        },"T1").start();
    }
}
