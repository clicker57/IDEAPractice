package practice.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 7/5/16.
 */
public class ArrPractice {

    private List<String> list = new ArrayList<>();

    public ArrPractice() {
        int num = 10000000;

        for (int i = 0; i < num; i++) {
            list.add("list" + i);
        }
    }

    public static void main(String[] args) {
        ArrPractice obj = new ArrPractice();

        obj.foreach();
        obj.forlist();
        obj.iteratorList();
        obj.forArray();
    }



    void foreach() {
        long start = System.currentTimeMillis();

        for (String s : list) {
            String value = s;
        }

        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("foreach list : " + count);
    }

    void forlist() {
        long start = System.currentTimeMillis();

        for (int i=0; i < list.size(); i++) {
            String value = list.get(i);
        }

        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("for list.size() : " + count);
    }

    void iteratorList() {
        long start = System.currentTimeMillis();

        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String value = it.next();
        }

        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("iterator : " + count);
    }

    void forArray() {
        long start = System.currentTimeMillis();

        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        for (String s : strArr) {
            String value = s;
        }

        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("forArray : " + count);
    }
}
