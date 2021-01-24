package com.leetcode.xzx.array;

public class LengthOfLCIS {

	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		System.out.println(findLengthOfLCIS(nums));

	}
	
	/**
	 * 674. 最长连续递增序列:
	 * 	https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
	 * @param nums
	 * @return
	 */
	public static int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0) return 0;
		int lastValue = Integer.MAX_VALUE;
		int maxLen = 0;
		int curLen = 1;
		for(int i =0; i< nums.length; i++) {
			if (nums[i] <= lastValue) {
				maxLen = curLen > maxLen ? curLen : maxLen;
				curLen = 1;
				lastValue = nums[i];
			} else {
				curLen++;
				lastValue = nums[i];
			}
		}
		maxLen = curLen > maxLen ? curLen : maxLen;
		return maxLen;
    }

}
