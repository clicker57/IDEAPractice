package practice.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TSyncronized implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(TSyncronized.class);

    static int i = 0;

    public void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increase();
        }
    }

    public static void main(String[] args) {
        TSyncronized tSyncronized = new TSyncronized();
        Thread aThread = new Thread(tSyncronized);
        Thread bThread = new Thread(tSyncronized);
        aThread.start();
        bThread.start();
        System.out.println("i = " + i);
    }
}
