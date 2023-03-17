package practice.threading;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiThreadsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
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
        Assert.assertNotNull(t1.gettName());
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