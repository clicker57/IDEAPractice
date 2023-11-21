package practice;

class ArrayWithLockOrder {
    private static long num_locks = 0;
    private long lock_order;
    private int[] arr;

    public ArrayWithLockOrder(int[] a) {
        arr = a;
        synchronized (ArrayWithLockOrder.class) {
            num_locks++;
            // 为此对象实例设置唯一的 lock_order
            lock_order = num_locks;
        }
    }

    public long lockOrder() {
        return lock_order;
    }

    public int[] array() {
        return arr;
    }
}

class SomeClass implements Runnable {
    public int sumArrays(ArrayWithLockOrder a1, ArrayWithLockOrder a2) {
        int value = 0;
        // 保留数组引用的一个
        ArrayWithLockOrder first = a1;
        // 本地副本。
        ArrayWithLockOrder last = a2;
        int size = a1.array().length;
        if (size == a2.array().length) {
            // 确定并设置对象的锁定
            if (a1.lockOrder() > a2.lockOrder()) {
                // 注意顺序
                first = a2;
                last = a1;
            }
            // 按正确的顺序锁定对象
            synchronized (first) {
                synchronized (last) {
                    int[] arr1 = a1.array();
                    int[] arr2 = a2.array();
                    for (int i = 0; i < size; i++) {
                        value += arr1[i] + arr2[i];
                    }
                }
            }
        }
        return value;
    }

    @Override
    public void run() {
        //
    }
}
