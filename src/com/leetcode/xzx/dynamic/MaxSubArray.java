package com.leetcode.xzx.dynamic;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/9 18:03
 **/

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }

    /**
     * f(i)表示第i个数结尾的 连续子数组的最大和， 则 f(i+1) = max{f(i)+nums[i],nums[i]}
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSum = nums[0]; // 初始默认最大
        for (int i : nums) {
            pre = Math.max(pre + i, i);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
