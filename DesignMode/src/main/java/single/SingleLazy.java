package single;

public class SingleLazy {
    private String id;

    private static volatile SingleLazy single = null;
    private static boolean hasInstance = false;

    private SingleLazy(){
        if (!hasInstance) {
            hasInstance = true;
        } else {
            throw new RuntimeException("�����������ظ�����");
        }
        System.out.println("SingleLazy creates a new instance.");
    }

    public static SingleLazy getInstance() {
        if (single == null) {
            synchronized (SingleLazy.class) {
                if (single == null) {
                    single = new SingleLazy();
                }
            }
        }
        return single;
    }
}
