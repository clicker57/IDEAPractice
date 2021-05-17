package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Objects;

/**
 * practice using java.io.Stream, java.io.Reader/Writer
 *
 * @author Philip
 */
public class FileDealing {
    private static final Logger logger = LoggerFactory.getLogger(FileDealing.class);

    public static void main(String[] args) throws IOException {
        FileDealing fd = new FileDealing();
        String src = "/Users/Philip/study/Java/Java深度历险.pdf";
        String dst = "/Users/Philip/workspaces/IDEAPractice/Crates/src/Java深度历险4.pdf";

        long startTime = System.currentTimeMillis();

        fd.basicStreamTrans(src, dst);    // 33955
//        fd.basicStreamArrayTrans(src, dst); // 78
//        fd.bufferedStreamTrans(src, dst); // 230
//        fd.bufferedStreamArrayTrans(src, dst);  // 21

        long endTime = System.currentTimeMillis();
        logger.info("time cost: {}", (endTime - startTime));
    }

    public void basicStreamTrans(String srcFile, String dstFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(srcFile); FileOutputStream fos = new FileOutputStream(dstFile)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
        }
    }

    public void basicStreamArrayTrans(String srcFile, String dstFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(srcFile); FileOutputStream fos = new FileOutputStream(dstFile)) {
            byte[] chArr = new byte[1024];
            int n;
            while ((n = fis.read(chArr)) > 0) {
                fos.write(chArr, 0, n);
            }
        }
    }

    public void bufferedStreamTrans(String srcFile, String dstFile) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstFile))) {
            int ch;
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }
        }
    }

    public void bufferedStreamArrayTrans(String srcFile, String dstFile) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstFile))) {
            byte[] chArr = new byte[1024];
            int n;
            while ((n = bis.read(chArr)) > 0) {
                bos.write(chArr, 0, n);
            }
        }
    }

    public void diveInFile(File file) {
        if (!file.exists()) {
            logger.info("Path does not exist : {}", file.getAbsolutePath());
            return;
        }
        logger.info(file.getAbsolutePath());
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File sf : Objects.requireNonNull(subFiles)) {
                diveInFile(sf);
            }
        }
    }
}