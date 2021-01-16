package com.pipi.xzx.weektest1038;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/13 21:25
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PIPISign {

    public static void main(String[] args) {
        // 获取数据
        Scanner inScanner = new Scanner(System.in);
        int n = inScanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = inScanner.nextInt();
        }
        int[] arr = Arrays.copyOf(nums, n); // 复制该数组的副本
        Arrays.sort(arr); // 将该数组排序
        int min = arr[0]; // 最小值
        int max = arr[n - 1]; // 最大值
        List<Integer> minArray = new ArrayList<Integer>(); // 记录最小值的位置数组
        List<Integer> maxArray = new ArrayList<Integer>(); // 记录最大值的位置数组
        for (int i = 0; i < n; i++) {
            if (nums[i] == min) minArray.add(i);
            else if (nums[i] == max) maxArray.add(i);
            else continue;
        }
        int min_dis = Integer.MAX_VALUE;
        for (Integer integer : minArray) {
            for (Integer integer2 : maxArray) {
                if (Math.abs(integer2 - integer) < min_dis) min_dis = Math.abs(integer2 - integer) + 1;
            }
        }
        System.out.println(min_dis);
    }

}
