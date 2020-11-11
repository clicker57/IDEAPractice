package practice;

public class InnerContainer {

    private final Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Method run of Runnable r");
        }
    };

    public InnerContainer() {
    }

    private static class InnerB {
        private final String f = InnerB.class.getSimpleName();

        public InnerB() {
        }
    }

    private class InnerA {
        private final String f = InnerA.class.getSimpleName();

        public InnerA() {
        }
    }
}