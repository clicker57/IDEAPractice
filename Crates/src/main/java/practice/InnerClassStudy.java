package practice;

/**
 *
 * Created by Philip on 04/07/2017.
 */
public class InnerClassStudy {
    private int a = 30;


    public static void main(String[] args) {
        InnerDemo ics = new InnerDemo();
        InnerDemo.InnerOrd ioObj = ics.new InnerOrd(3);
        System.out.println("InnerOrd --- x: " + ioObj.x);

        InnerDemo.InnerStatic isObj = new InnerDemo.InnerStatic(5);
        System.out.println("InnerStatic --- x: " + isObj.x);
        InnerDemo.InnerStatic.sayHi();
        isObj.sayHi("Lily");
        InnerDemo.InnerStatic.sayHi();

    }
}

class InnerDemo{
    class InnerOrd{
        int x = 1;

        public InnerOrd(int b) {
            System.out.println("InnerOrd --- b: " + b);
        }
    }
    static class InnerStatic{
        int x = 1;

        public InnerStatic(int a) {
            System.out.println("InnerStatic --- a: " + a);
        }

        public static void sayHi() {
            System.out.println("Hi there");
        }

        public void sayHi(String s) {
            System.out.println("Hi " + s + " --- " + x++);
        }
    }

}