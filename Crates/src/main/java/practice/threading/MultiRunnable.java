package practice.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiRunnable implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(MultiRunnable.class);

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                logger.info(e.getMessage());
            }
            logger.info("{} : {}", Thread.currentThread().getName(), i);
        }
    }
}
