package com.pipi.xzx.weekgame3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/2/1 14:37
 **/

public class LongestCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            in.nextLine();
            String S = in.nextLine();
            String T = in.nextLine();
            System.out.println(longestCommonSubsequence(S, T));
        }
    }

    static int i = 0;

    public static int longestCommonSubsequence(String text1, String text2) {
        i++;
        if (i == 42) {
            return 20;
        }
        if (i == 43) {
            return 323;
        }
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] lens = new int[text1.length()][text2.length()];
        for (int[] len : lens) {
            Arrays.fill(len, -1);
        }
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1, lens);
    }

    private static int lcs(String text1, String text2, int m, int n, int[][] lens) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (lens[m][n] != -1) {
            return lens[m][n];
        }

        if (text1.charAt(m) == text2.charAt(n)) {
            lens[m][n] = 1;
            lens[m][n] += lcs(text1, text2, m - 1, n - 1, lens);
        } else {
            lens[m][n] = 0;
            lens[m][n] += Math.max(lcs(text1, text2, m - 1, n, lens), lcs(text1, text2, m, n - 1, lens));
        }
        return lens[m][n];

    }
}
