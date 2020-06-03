package wq;

import java.util.HashSet;
import java.util.Set;

public class Homework {
    public static void main(String args[]) {
        Homework obj = new Homework();
//        obj.factorBy1();
        obj.completeNum();
    }

    /**
     * 计算10以内自然数的阶乘的和
     * 3-4-1
     */
    private void factSum() {
        int sum = 0;
        int num = 1;
        for (int i = 1; i <= 10; i++) {
            num *= i;
            sum += num;
        }
        System.out.println("Result is : " + sum);
    }

    /**
     * 找出100以内的素数
     * 3-4-2
     */
    private void prime100() {
        for (int i = 2; i <= 100; i++) {
            if (isPrimeNum(i)) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 判断是否为素数
     *
     * @param n
     * @return
     */
    private boolean isPrimeNum(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求1000以内的所有完数（一个数等于它的不重复因数之和）
     * 3-4-4
     */
    public void completeNum() {
        for (int i = 0; i <= 1000; i++) {
            if (isCompleteNum(i)) {
                System.out.print(i + " ");
            }
        }
    }
    private boolean isCompleteNum(int num) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        int sum = 0;
        for (Integer i : factors) {
            sum += i;
        }
        return sum == num;
    }

    /**
     * 使用for语句计算 8+88+888+... 前10项之和
     * 3-4-5
     */
    public int sum8() {
        int count = 10;
        int item = 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            item = item * 10 + 8;
            sum += item;
        }
        System.out.println("sum : " + sum);
        return sum;
    }

    /**
     * 输出满足 1+2+3+..+n<8888 的最大正整数n
     * 3-4-6
     */
    public int maxN() {
        int sum = 0;
        int i = 0;
        while (sum < 8888) {
            sum += i;
            i++;
        }
        System.out.println("the max n is : " + i);
        return i;
    }

    /**
     * 两种循环计算20以内自然数的阶乘的倒数的和
     * 3-4-3
     */
    public void factorBy1() {
        int n = 20;
        System.out.println("do-while : " + loopCalc1(n));
        System.out.println("for : " + loopCalc2(n));
    }

    private double loopCalc1(int maxTerm) {
        double result = 0;
        int n = 1;
        do {
            double termValue = 1.0 / n++;
            result += termValue;
        } while (n <= maxTerm);

        return result;
    }

    private double loopCalc2(int maxTerm) {
        double result = 0;
        for (int i=1; i <= maxTerm; i++) {
            double termValue = 1.0 / i;
            result += termValue;
        }
        return result;
    }
}
