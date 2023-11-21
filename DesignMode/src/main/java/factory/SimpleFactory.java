package factory;

public class SimpleFactory {
    public static ISimpleInstance getInstance(String oper) {
        ISimpleInstance instance = null;
        switch (oper) {
            case "+" : instance = new add(); break;
            case "-" : instance = new subtract(); break;
            default:
        }
        if (instance == null) {
            System.out.println("Invalid operator!");
        }
        return instance;
    }
}
