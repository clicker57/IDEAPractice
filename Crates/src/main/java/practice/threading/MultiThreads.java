package practice.threading;

public class MultiThreads extends Thread {
    private static Integer counter = 0;
    private String tName;
    private int tOrder;

    public MultiThreads(int tOrder) {
        this.tOrder = tOrder;
        this.tName = "t" + tOrder;
    }

    @Override
    public void run() {
        for (int i=0; i < 10; i++) {
            if (tOrder % 2 == 1) {
                odd();
            } else {
                even();
            }
        }
    }

    public void odd() {
        synchronized(counter) {
            while (counter % 2 != 1) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(this.tName + " ----- " + counter);
            counter++;
            notifyAll();
        }
    }

    public void even() {
        synchronized(counter) {
            while (counter % 2 != 0) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(this.tName + " ----- " + counter++);
            notifyAll();
        }
    }

    public static void main(String[] args) {
        MultiThreads t1 = new MultiThreads(1);
        MultiThreads t2 = new MultiThreads(2);

        t1.start();
        t2.start();
    }
}
