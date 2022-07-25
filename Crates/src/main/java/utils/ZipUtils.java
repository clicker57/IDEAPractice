package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class ZipUtils {
    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    private ZipUtils() {}

    public static byte[] getBytes(String encoding, String name) throws UnsupportedEncodingException {
        if (encoding == null) {
            return name.getBytes();
        } else {
            logger.info("encoding : {}", encoding);
            return name.getBytes(encoding);
        }
    }
}
