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
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
//		Scanner inScanner = new Scanner(System.in);
//		while (inScanner.hasNext()) {
//			int num = inScanner.nextInt();
//			System.out.println(climbStairs(num));
//		}
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
