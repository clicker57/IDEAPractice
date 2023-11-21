package practice.threading;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiThreadsTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    public static void main(String[] args) {
        MultiThreadsTest obj = new MultiThreadsTest();
        obj.multiRunnable();
    }

    @Test
    public void multiThread() {
        MultiThreads t1 = new MultiThreads(1);
        MultiThreads t2 = new MultiThreads(2);

        t1.start();
        t2.start();
        Assertions.assertNotNull(t1.gettName());
    }

//    @Test
    public void multiRunnable() {
        MultiRunnable mr = new MultiRunnable();

        Thread t1 = new Thread(mr, "t张三");
        Thread t2 = new Thread(mr, "t里斯");

        t1.start();
        t2.start();
    }
}