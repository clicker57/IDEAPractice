package single;

/**
 * 静态内部类实现单例模式
 */
public class Single01 {
    private Single01() {
    }

    public static Single01 getInstance() {
        return SingleHolder.instance;
    }

    public void doBusiness() {
        // 业务逻辑
    }

    private static class SingleHolder {
        private final static Single01 instance = new Single01();
    }
}
