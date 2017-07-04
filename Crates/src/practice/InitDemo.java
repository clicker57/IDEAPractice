package practice;

/**
 * Created by Philip on 03/07/2017.
 */
public class InitDemo extends Init1{
    static int x = 0;
    int a;

    InitDemo(int a) {
        this.a = a;
        System.out.println("InitDemo this.a = " + a);
    }

    {
        System.out.println("InitDemo for obj ..." + this.a);
    }

    static {
        System.out.println("InitDemo for static ... x=" + x);
        x++;
    }
}

class Init1 {
    Init1() {
        System.out.println("Init1 for obj ...");
    }
}

class Demo {
    public static void main(String[] args) {
        InitDemo id1 = new InitDemo(100);
        System.out.println("id1 created. x = " + InitDemo.x);

        InitDemo id2 = new InitDemo(200);
        System.out.println("id2 created. x = " + InitDemo.x);
    }
}