package practice.arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 7/5/16.
 */
public class ArrPractice {

    private final List<String> list = new ArrayList<>();

    public ArrPractice() {
        int num = 10000000;

        for (int i = 0; i < num; i++) {
            list.add("list" + i);
        }
    }

    public static void main(String[] args) {
        ArrPractice obj = new ArrPractice();

        obj.transToJson();
        obj.iteratorList();
        obj.foreach();
        obj.forlist();
        obj.forArray();
    }

    void transToJson() {
        List<String> li = new ArrayList<>();
        li.add("a1");
        li.add("a2");
        li.add("a3");
        System.out.println("list : " + li);

        String jsonStr = JSON.toJSONString(li);
        System.out.println("json string : " + jsonStr);

        List<String> li2 = JSON.parseArray(jsonStr, String.class);
        String[] strArray = li2.toArray(new String[0]);
        System.out.println("object [] : " + Arrays.toString(strArray));

        JSONObject obj = new JSONObject();
        for (int i = 0; i < 5; i++) {
            obj.put("KK", "");
        }
        System.out.println("get null : " + JSON.toJSONString(obj));
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
