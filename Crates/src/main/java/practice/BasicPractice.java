package practice;

import day08.exercise1.Director;

import javax.xml.transform.Source;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * @author Philip
 */
public class BasicPractice {

    public static void main(String[] args) throws InterruptedException {
        long beginT = System.currentTimeMillis();
        long endT = System.currentTimeMillis();

        BasicPractice obj = new BasicPractice();

        // 字符串转date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = sdf.parse("2019-12-30", new ParsePosition(0));
        System.out.println("new date: " + newDate.toString());

        List<String> sl = new ArrayList<>();
        sl.add("1");
        sl.add("2");
        sl = sl.subList(0, 2);
        System.out.println(sl);
    }

    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    public static String MD5(String pwd) {
        //用于加密的字符
        char[] md5String = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }

            //返回经过加密后的字符串
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }
}
