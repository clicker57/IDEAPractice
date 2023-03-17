package practice.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThreads extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(MultiThreads.class);

    private static Integer counter = 0;
    private final String tName;
    private final int tOrder;

    public MultiThreads(int tOrder) {
        this.tOrder = tOrder;
        this.tName = "t" + tOrder;
    }

    public String gettName() {
        return this.tName;
    }

    @Override
    public void run() {
        for (int i=0; i < 50; i++) {
            if (tOrder % 2 == 1) {
                odd();
            } else {
                even();
            }
            logger.info("{} : {}", gettName(), i);
        }
    }

    public void odd() {
        synchronized(counter) {
            while (counter % 2 == 1) {
                notifyAll();
                System.out.println(this.tName + " ----- " + counter);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void even() {
        synchronized(counter) {
            while (counter % 2 == 0) {
                notifyAll();
                System.out.println(this.tName + " ----- " + counter++);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
