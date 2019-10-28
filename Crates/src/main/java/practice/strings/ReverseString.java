package practice.strings;

/**
 * 逆转字符串
 * description: 输入一个字符串，将其逆转并输出。
 * Created by Philip on 6/23/16.
 */
public class ReverseString {
    public static String doReverse(String inStr) {
        if (inStr.length() > 0) {
            char outStrCh[] = new char[inStr.length()];
            for (int i = 0; i < inStr.length(); i++) {
                outStrCh[i] = inStr.charAt(inStr.length() - i - 1);
            }
            return new String(outStrCh);
        }
        return "";
    }
}
