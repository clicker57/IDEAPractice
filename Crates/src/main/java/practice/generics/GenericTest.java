package practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args){
        List<? extends Apple> list1 = new ArrayList<>();
        List<? super ApplePie> list2 = new ArrayList<>();

//        list1.add(new Fruit());    // invalid
        Apple newApple = list1.get(0);

        list2.add(new ApplePie());
        list2.add(new ApplePieBox());
//        list2.add(new Apple());    // invalid
    }

    public static<T> T getData(List<T> data) {
        System.out.println("data: " + data.get(0));
        return data.get(0);
    }

    public static void getNumber(List<? extends Number> data) {
        System.out.println("number: " + data.get(0));
    }

    public static void getNumber2(List<? super Number> data) {
        System.out.println("number: " + data.get(0));
    }
}

class ApplePie extends Apple{}
class ApplePieBox extends ApplePie{}
