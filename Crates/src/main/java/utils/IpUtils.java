package utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class IpUtils {
    public static long ipv4StringToLong(String ipStr) {
        long sum = 0L;
        for (String s : ipStr.split("\\.")) {
            long i = Long.parseLong(s);
            sum = sum << 8;
            sum += i;
            System.out.println();
        }
        return sum;
    }

    public static String ipv4LongToString(Long ipValue) {
        List<Long> ipParts = new ArrayList<>();
        while (ipValue > 0) {
            ipParts.add(0, ipValue % 256);
            ipValue = ipValue >>> 8;
        }
        StringBuilder sb = new StringBuilder();
        for (Long n : ipParts) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(n);
        }
        return sb.toString();
    }

    public static BigInteger ipv6ToInteger(String ipStr) {
        BigInteger sum = new BigInteger("0");
        for (String s : ipStr.split(":")) {
            long i = Long.parseLong(s, 16);
            sum = sum.shiftLeft(16);
            sum = sum.add(new BigInteger(String.valueOf(i)));
            System.out.println();
        }
        return sum;
    }

    public static String ipv6ToString(BigInteger ipValue) {
        List<String> ipParts = new ArrayList<>();
        while (!ipValue.equals(BigInteger.ZERO)) {
            BigInteger mod = ipValue.mod(new BigInteger(String.valueOf(16 ^ 4)));
            ipParts.add(0, mod.toString(16));
            ipValue = ipValue.shiftRight(16);
        }
        for (int i = ipParts.size(); i < 8; i++) {
            ipParts.add(0, "0");
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ipParts) {
            if (sb.length() > 0) {
                sb.append(":");
            }
            sb.append(String.format("%4s", s).replace(" ", "0"));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long result = ipv4StringToLong("111.18.142.60");
        System.out.println(result);
        String ip1 = ipv4LongToString(Long.parseLong("16777472"));
        System.out.println(ip1);

        BigInteger res2 = ipv6ToInteger("fe00:0000:0000:0000:0000:0000:0000:0000");
        System.out.println(res2);
        // 281470698520576 58569024899333240586683499811191128064
        String ip2 = ipv6ToString(new BigInteger("58569024899333240586683499811191128064"));
        System.out.println(ip2);
    }
}
