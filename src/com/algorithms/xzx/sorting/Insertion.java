package com.algorithms.xzx.sorting;

import com.algorithms.xzx.file.WriteAndReadFile;

/**
 * @outhor 智祥
 * @create 2018-08-21 18:24
 */
public class Insertion {

    /**
     * 插入排序：
     * 依次插入已排好序的元素中
     *
     * @param a
     */
    public static void InsertSort1(int[] a) {
        // 升序
        int N = a.length;
        // 依次交换两个数
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int T = a[j];
                a[j] = a[j - 1];
                a[j - 1] = T;
            }
        }
    }

    /**
     * 直接插入排序：先找到插入位置再插入
     *
     * @param nums
     * @param n
     */
    public static void InsertSort2(int[] nums, int n) {
        int temp;
        for (int i = 1; i < n; i++) {
            temp = nums[i];
            int j = i;
            for (; j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /**
     * 直接插入排序：二分法查找插入位置
     *
     * @param nums
     * @param n
     */
    public static void InsertSort3(int[] nums, int n) {
        int temp;
        for (int i = 1; i < n; i++) {
            temp = nums[i];
            int low = 0, high = i - 1;
            int mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > temp) high = mid - 1;
                else low = mid + 1;
            }
            for (int j = i; j > low; j--) {
                nums[j] = nums[j - 1];
            }
            nums[low] = temp;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = WriteAndReadFile.readFromFile();
        //WriteAndReadFile.show(a);
        // System.out.println("");
        if (a == null) return;
        InsertSort3(a, a.length);
        InsertSort1(a);
        InsertSort2(a, a.length);
        WriteAndReadFile.show(a);
    }
}
