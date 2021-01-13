package com.leetcode.xzx.math;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/13 18:02
 **/

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(countPrimes_violence(3));
        System.out.println(countPrimes_violence2(3));
        System.out.println(countPrimes_filter(3));
        System.out.println(isPowerOfThree(2));
    }

    /**
     * 判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        while (n >= 2 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    /**
     * 筛选法 统计所有小于非负整数 n 的质数的数量
     *
     * @param n
     * @return
     */
    public static int countPrimes_filter(int n) {
        boolean[] sign = new boolean[n]; // 标记数组
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!sign[i]) {
                cnt++;
                for (int j = i + i; j < n; j += i) { // 过滤掉所有该数的倍数
                    sign[j] = true;
                }
            }
        }
        return cnt;
    }

    /**
     * 优化 暴力统计所有小于非负整数 n 的质数的数量
     * 避开偶数减少一部分计算量
     *
     * @param n
     * @return
     */
    public static int countPrimes_violence2(int n) {
        if (n <= 2) return 0;
        int cnt = 1;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrime(i))
                cnt++;
        }
        return cnt;
    }

    /**
     * 暴力统计所有小于非负整数 n 的质数的数量
     *
     * @param n
     * @return
     */
    public static int countPrimes_violence(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i))
                cnt++;
        }
        return cnt;
    }

    /**
     * 判断n是否为质数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        int k = (int) Math.sqrt(n);
        for (int i = 2; i <= k; i++)
            if (n % i == 0) return false;
        return true;
    }
}
