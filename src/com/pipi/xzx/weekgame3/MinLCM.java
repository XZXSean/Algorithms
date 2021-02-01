package com.pipi.xzx.weekgame3;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/2/1 14:00
 **/

public class MinLCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(getMinLCM(arr, k));
        }
    }

    public static int getMinLCM(int[] arr, int k) {
        int cnt = 0;
        int temp = arr[k - 1];
        while (cnt < k) {
            for (int i : arr) {
                if (temp % i == 0) cnt++;
            }
            if (cnt >= k) return temp;
            temp++;
            cnt = 0;
        }
        return 0;
    }
}
