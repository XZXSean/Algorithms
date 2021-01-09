package com.leetcode.xzx.dynamic;

import java.util.Arrays;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/9 18:03
 **/

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));


        int[] robs = {2, 7, 9, 3, 1};
        System.out.println(rob(robs));

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

    public static int rob(int[] nums) {
        return robTwo(nums, nums.length, new int[nums.length]);
    }

    /**
     * s1: 当数组长度为0直接返回，数组长度为1时，返回该一个元素即可
     * s2: 记前 i 个元素中最大的元素值和为 f(i),则 f(i+1) = max{f(i-2)+nums[i], f(i-1)};
     *
     * @param nums
     * @param n
     * @param memo
     * @return
     */
    public static int robTwo(int[] nums, int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                memo[0] = nums[0]; // 记录 f(0)
            } else if (i == 1) {
                memo[1] = Math.max(nums[0], nums[1]); // 记录 f(1)
            } else {
                memo[i] = Math.max(memo[i - 2] + nums[i], memo[i - 1]);
            }
        }
        Arrays.sort(memo); // 排序后取最大值
        return memo[n - 1];
    }
}
