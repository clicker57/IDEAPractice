package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Philip
 */
public class BasicPractice {
    private static final Logger logger = LoggerFactory.getLogger(BasicPractice.class);

    public static void main(String[] args) {
        // 字符串转date
        String format1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        logger.info("format1: {}", format1);
        String format2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS"));
        logger.info("format2: {}", format2);

        DecimalFormat df = new DecimalFormat("0.00#");
        BigDecimal fact = BigDecimal.valueOf(1110.000);
        logger.info(df.format(fact));
        logger.info(String.valueOf(fact.setScale(6, RoundingMode.HALF_DOWN)));

        df = new DecimalFormat("#.###############");
        String s = df.format(fact);
        logger.info("s = {}", s);

        Calendar cal = Calendar.getInstance();
        cal.set(2022, 0, 18);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentTime = sdf.format(cal.getTime());
        logger.info("current date : {}", currentTime);
        String thisMonday = sdf.format(getThisWeekMonday(cal.getTime()));
        logger.info("Monday this week : {}", thisMonday);
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    private static void demoLocalDate() {
        // date -> localdate
        Date dt1 = new Date();
        LocalDate ld1 = dt1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        logger.info("date -> localdate : {}", ld1);

        // localdate -> date
        LocalDate ld2 = LocalDate.now();
        ZonedDateTime zonedDateTime = ld2.atStartOfDay(ZoneId.systemDefault());
        Date dt2 = Date.from(zonedDateTime.toInstant());
        logger.info("localdate -> date : {}", dt2);

        LocalDate ld = LocalDate.of(2021, 6, 28);
        long diffMon = ChronoUnit.MONTHS.between(ld, LocalDate.now());
        logger.info("the interval of months is {}", diffMon);
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

    public static String doMD5(String pwd) {
        //用于加密的字符
        char[] md5String = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
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
