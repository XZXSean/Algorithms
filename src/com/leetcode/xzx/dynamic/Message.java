package com.leetcode.xzx.dynamic;

public class Message {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int massage(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int[][] dp = new int[nums.length][2];
		dp[0][0] = 0; // 第一个没接
		dp[0][1] = nums[0]; // 第一个接了
		for (int i = 1; i < nums.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = dp[i - 1][0] + nums[i];
		}
		return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
	}

}
