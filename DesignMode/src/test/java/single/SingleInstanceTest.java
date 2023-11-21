package single;

import java.lang.reflect.InvocationTargetException;

public class SingleInstanceTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        SingleHungry obj1 = SingleHungry.getInstance();
//        SingleHungry obj2 = SingleHungry.getInstance();
//        System.out.println("obj1 --- " + obj1.hashCode());
//        System.out.println("obj2 --- " + obj2.hashCode());

//        SingleLazy lazy1 = SingleLazy.getInstance();
//        System.out.println("lazy1 --- " + lazy1.hashCode());

//        Constructor constructor = SingleLazy.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Field hasInstance = SingleLazy.class.getDeclaredField("hasInstance");
//        hasInstance.setAccessible(true);
//        SingleLazy lazy2 = (SingleLazy) constructor.newInstance();
//        System.out.println("lazy2 --- " + lazy2.hashCode());
//
//        SingleLazy lazy3 = (SingleLazy) constructor.newInstance();
//        System.out.println("lazy3 --- " + lazy3.hashCode());
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(Single01.getInstance().hashCode());
            }).start();
        }
    }
}