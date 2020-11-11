package practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class InnerClassReflection {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class clazz = InnerContainer.class;
        InnerContainer container = (InnerContainer) clazz.newInstance();
        Class[] innerClazz = clazz.getDeclaredClasses();
        for (Class cls : innerClazz) {
            int mod = cls.getModifiers();
            String modifier = Modifier.toString(mod);
            if (modifier.contains("static")) {
                //构造静态内部类实例
//              Constructor con1 = cls.getDeclaredConstructor();
                Object obj1 = cls.newInstance();
                Field field1 = cls.getDeclaredField("f");
                field1.setAccessible(true);
                System.out.println(field1.get(obj1));
            } else {
                // 构造成员内部类实例
                Constructor con2 = cls.getDeclaredConstructor(clazz);
                con2.setAccessible(true);
                Object obj2 = con2.newInstance(container);
                Field field2 = cls.getDeclaredField("f");
                field2.setAccessible(true);
                System.out.println(field2.get(obj2));
            }
        }
        // 获取匿名内部类实例
        Field field = clazz.getDeclaredField("r");
        field.setAccessible(true);
        Runnable r = (Runnable) field.get(container);
        r.run();
    }
}
