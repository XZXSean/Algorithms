package com.pipi.xzx.weekgame3;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/2/1 15:57
 **/

public class FlipGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[] buffer = in.nextLine().toCharArray();
        System.out.println(getMinOperaTimes(buffer, n));
    }

    public static int getMinOperaTimes(char[] buffer, int n) {
        int[] record0 = new int[n]; // 用来记录当前位置及前的0的个数
        int[] record1 = new int[n]; // 用来记录当前位置及之后的1的个数
        record0[0] = buffer[0] == '0' ? 1 : 0;
        record1[n - 1] = buffer[n - 1] == '1' ? 1 : 0;
        for (int i = 1; i < buffer.length; i++) {
            record0[i] = buffer[i] == '0' ? record0[i - 1] + 1 : record0[i - 1];
            record1[n - i - 1] = buffer[n - i - 1] == '1' ? record1[n - i] + 1 : record1[n - i];
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            res = Math.min((i + 1 - record0[i]) + (n - i - 1 - record1[i]), res);
        }
        return res;
    }
}
