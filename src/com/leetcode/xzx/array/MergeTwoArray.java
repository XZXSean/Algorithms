package com.leetcode.xzx.array;

import java.util.Arrays;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/7 18:10
 **/

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {2};
        merge(nums1, 0, nums2, 1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

//        System.out.println(Arrays.toString(nums1) + "\t" + Arrays.toString(nums2));
    }

}
