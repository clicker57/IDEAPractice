package Tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Philip on 27/05/2017.
 */
public class EncryptUtils {
    public static String encryption001(String plain) {
        String encoded;
        StringBuilder sb = new StringBuilder();

        try {
            encoded = URLEncoder.encode(plain, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            encoded = "";
        }

        String[] wordGroup = encoded.split("%");
        for (String s : wordGroup) {
            if (s != null && s.length() > 1) {
                char shiftedLast = (char) (s.charAt(s.length() - 1) + 1);
                s = s.substring(0, s.length() - 1) + String.valueOf(shiftedLast);
                sb.append("%" + s);
            }
        }

        return sb.toString();
    }

    public static String decryption001(String cipher) {
        String decoded;
        StringBuilder sb = new StringBuilder();

        String[] wordGroup = cipher.split("%");
        for (String s : wordGroup) {
            if (s != null && s.length() > 1) {
                char shiftedLast = (char) (s.charAt(s.length() - 1) - 1);
                s = s.substring(0, s.length() - 1) + String.valueOf(shiftedLast);
                sb.append("%" + s);
            }
        }

        try {
            decoded = URLDecoder.decode(sb.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            decoded = "";
        }

        return decoded;
    }

    public static String encryption002(String plain) {
        return "";
    }

    public static void main(String[] args) {
        String inStr;

        inStr = encryption001("测试");
        System.out.println(inStr);

        System.out.println(decryption001(inStr));
    }
}
