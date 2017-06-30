package javaprogramming;

/**
 * description: 用“埃氏筛法”求2～10000以内的素数。
 *              要求使用数组，使用数组的长度，使用增强的for语句。
 * file-encoding: UTF-8
 * Created by hockidoggy on 23/06/2017.
 */
public class Eratosthenes {
    /**
     * 由于增强的for语句仅支持读操作，所以我的设计思路是将原始数据存入数组，利用筛法把不符合要求的数据清零。
     * 最后用增强的for语句读取数组中剩余的数据。
     *
     * @param args
     */
    public static void main(String[] args) {
        int MAX_N = 10000;
        int numbers[] = new int [MAX_N];

        // 初始化，存储从1到最大值
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        for (int factor = 2; factor <= MAX_N; factor++) {
            // 既然是倍数，那么小于因子的直接过滤，因子的相邻倍数之间的数字也都不必遍历
            for (int i = factor - 1; i < numbers.length; i += factor) {
                if (i + 1 != factor) {      // 不能把因子本身删除
                    numbers[i] = 0;
                }
            }
        }

        int counter = 0;
        for (int n : numbers) {
            if (n > 1) {
                System.out.printf("%4d ", n);
                counter++;
                if (counter % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
}
