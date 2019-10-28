package practice;

/**
 * Created by Philip on 03/07/2017.
 */
public class FinalizeDemo {
    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

        try {
            System.out.println("objects created ...");
            System.out.println("c1 --- " + c1.getClass().toString());
            System.out.println("c2 --- " + c2.getClass().toString());
            System.out.println("c3 --- " + c3.getClass().toString());
        } catch (Exception e) {
            System.out.println();
        }

        c2 = c3;
        c3 = null;

        try {
            System.out.println("after dereference ...");
            System.out.println("c1 --- " + c1.getClass().toString());
            System.out.println("c2 --- " + c2.getClass().toString());
            System.out.println("c3 --- " + c3.getClass().toString());
        } catch (Exception e) {
            System.out.println();
        }

        System.gc();

        c2 = null;

        try {
            System.out.println("after gc ...");
            System.out.println("c1 --- " + c1.getClass().toString());
            System.out.println("c2 --- " + c2.getClass().toString());
            System.out.println("c3 --- " + c3.getClass().toString());
        } catch (Exception e) {
            System.out.println();
        }

    }
}

class Cake{
    private int id;

    Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + " is created.");
    }

    @Override
    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake object " + id + " is disposed.");
    }
}