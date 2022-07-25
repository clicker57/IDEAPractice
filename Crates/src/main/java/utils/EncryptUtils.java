package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Philip on 27/05/2017.
 */
public class EncryptUtils {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

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
                s = s.substring(0, s.length() - 1) + shiftedLast;
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
                s = s.substring(0, s.length() - 1) + shiftedLast;
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

    public static void main(String[] args) {
        String inStr;

        inStr = encryption001("测试");
        logger.info(inStr);

        String outStr = decryption001(inStr);
        logger.info(outStr);
    }
}
