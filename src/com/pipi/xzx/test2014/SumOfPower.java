package com.pipi.xzx.test2014;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/16 18:19
 **/

public class SumOfPower {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int n = inScanner.nextInt();
            int m = inScanner.nextInt();
            countSumOfPower(n, m);
        }
    }

    public static void countSumOfPower(int n, int m) {
        // 此处使用long是避免整数超过上限
        long sum_odd = 0; // 奇数
        long sum_even = 0; // 偶数
        for (int i = n; i <= m; i++) {
            if (i % 2 == 0) {
                sum_even += Math.pow(i, 2);
            } else {
                sum_odd += Math.pow(i, 3);
            }
        }
        System.out.println(sum_even + " " + sum_odd);
    }
}
