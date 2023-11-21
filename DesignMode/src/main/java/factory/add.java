package factory;

public class add implements ISimpleInstance {
    @Override
    public Integer getResult(Integer a, Integer b) {
        if (a == null || b == null) {
            return null;
        }
        return a + b;
    }
}
