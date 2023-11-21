package single;

/**
 * ��̬�ڲ���ʵ�ֵ���ģʽ
 */
public class Single01 {
    private Single01() {
    }

    public static Single01 getInstance() {
        return SingleHolder.instance;
    }

    public void doBusiness() {
        // ҵ���߼�
    }

    private static class SingleHolder {
        private final static Single01 instance = new Single01();
    }
}
