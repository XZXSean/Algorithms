package com.leetcode.xzx.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/8 19:37
 **/

public class ClimbStairs {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int num = inScanner.nextInt();
            System.out.println(climbStairs(num));

        }
    }

    public static int climbStairs(int n) {
        int[] nums = new int[n + 1];
        return climbStairsMemo(n, nums);
    }

    public static int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) return memo[n];
        if (n == 1) memo[1] = 1;
        else if (n == 2) memo[2] = 2;
        else memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }

}
