package factory;

public class subtract implements ISimpleInstance {
    @Override
    public Integer getResult(Integer a, Integer b) {
        if (a == null || b == null) {
            return null;
        }
        return a - b;
    }
}
