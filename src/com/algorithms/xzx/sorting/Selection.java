package com.algorithms.xzx.sorting;

import com.algorithms.xzx.file.WriteAndReadFile;

/**
 * @outhor 智祥
 * @create 2018-08-20 23:04
 */
public class Selection {


    /**
     * 选择排序：
     * 选择最小的，然后换到最前面
     *
     * @param a
     */
    public static void sort(int[] a) {
        // 升序
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) { // 找到最小的值，交换
                    min = j;
                }
            }
            int T = a[i];
            a[i] = a[min];
            a[min] = T;
        }
    }

    public static void main(String[] args) {
        int[] a = WriteAndReadFile.readFromFile();
        WriteAndReadFile.show(a);
        System.out.println("\n");
        sort(a);
        WriteAndReadFile.show(a);
    }
}
