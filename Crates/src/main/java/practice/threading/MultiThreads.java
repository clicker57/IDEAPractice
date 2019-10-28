package practice.threading;

public class MultiThreads extends Thread {
    private int counter = 0;
    private String tName;
    private int tOrder;

    public MultiThreads(int tOrder) {
        this.tOrder = tOrder;
        this.tName = "t" + this.tOrder;
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

    public synchronized void odd() {
        while (this.counter%2 != 1) {
            try{
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.tName + " ----- " + this.counter++);
        notifyAll();
    }

    public synchronized void even() {
        while (this.counter%2 != 0) {
            try{
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.tName + " ----- " + this.counter++);
        notifyAll();
    }

    public static void main(String[] args) {
        MultiThreads t1 = new MultiThreads(1);
        MultiThreads t2 = new MultiThreads(2);

        t1.start();
        t2.start();
    }
}
