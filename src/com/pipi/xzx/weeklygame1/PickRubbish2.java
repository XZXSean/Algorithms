package com.pipi.xzx.weeklygame1;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/19 12:47
 **/

public class PickRubbish2 {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int n = inScanner.nextInt();
        int[] ai = new int[n];
        for (int i = 0; i < n; i++) {
            int num = inScanner.nextInt();
            // 依次用插入法插入每个元素
            int j = i;
            while (j > 0 && num < ai[j - 1]) {
                ai[j] = ai[--j];
            }
            ai[j] = num;
            if (i % 2 == 0) { // 当前有奇数个元素
                System.out.printf("%.20f\n", (double) ai[i / 2]);
            } else {
                System.out.printf("%.20f\n", (double) (ai[i / 2] + ai[i / 2 + 1]) / 2);
            }

        }
    }

}
