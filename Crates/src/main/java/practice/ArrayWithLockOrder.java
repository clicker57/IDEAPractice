package practice;

class ArrayWithLockOrder {
    private static long num_locks = 0;
    private long lock_order;
    private int[] arr;

    public ArrayWithLockOrder(int[] a) {
        arr = a;
        synchronized (ArrayWithLockOrder.class) {
            num_locks++;
            // Ϊ�˶���ʵ������Ψһ�� lock_order
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
        // �����������õ�һ��
        ArrayWithLockOrder first = a1;
        // ���ظ�����
        ArrayWithLockOrder last = a2;
        int size = a1.array().length;
        if (size == a2.array().length) {
            // ȷ�������ö��������
            if (a1.lockOrder() > a2.lockOrder()) {
                // ע��˳��
                first = a2;
                last = a1;
            }
            // ����ȷ��˳����������
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
