package com.leetcode.xzx.dynamic;

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
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(cost));
		System.out.println(waysToStep(61));
//		Scanner inScanner = new Scanner(System.in);
//		while (inScanner.hasNext()) {
//			int num = inScanner.nextInt();
//			System.out.println(climbStairs(num));
//		}
	}

	/**
	 * 面试题 08.01. 三步问题:https://leetcode-cn.com/problems/three-steps-problem-lcci/
	 * 数组dp 代表每个位置的方法次数 dp[0] = 1; // 1步 dp[1] = 2; // 1 or 2 步 dp[2] = 4; // 3个1步
	 * or 1步+2步 or 2步+1步 or 3步
	 * 
	 * @param n
	 * @return
	 */
	public static int waysToStep(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;
		long[] dp = new long[n];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for (int i = 3; i < n; i++) {
			dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000007;
		}
		return (int)dp[n - 1];
	}

	/**
	 * 746. 使用最小花费爬楼梯: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
	 * 
	 * 长度为 n+1 的数组 dp用来保存每个位置的最小花费
	 * 
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[n];
	}

	/**
	 * 70. 爬楼梯: https://leetcode-cn.com/problems/climbing-stairs/
	 * 
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		int[] nums = new int[n + 1];
		return climbStairsMemo(n, nums);
	}

	public static int climbStairsMemo(int n, int[] memo) {
		if (memo[n] > 0)
			return memo[n];
		if (n == 1)
			memo[1] = 1;
		else if (n == 2)
			memo[2] = 2;
		else
			memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
		return memo[n];
	}

}
