package com.algorithms.xzx.sorting;

import com.algorithms.xzx.file.WriteAndReadFile;

import java.util.Arrays;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/3 18:37
 **/

public class MergeSort {

    public static void merge(int[] A, int low, int mid, int high) {
        int[] B = new int[A.length];
        // 将数组先复制到新数组中
        if (high - low >= 0) System.arraycopy(A, low, B, low, high - low + 1);
        int i, j, k;
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            if (B[i] <= B[j]) A[k] = B[i++];
            else A[k] = B[j++];
        }
        while (i <= mid) A[k++] = B[i++];
        while (j <= high) A[k++] = B[j++];
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (a == null || a.length == 0) return;
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void main(String[] args) {
        int[] a = WriteAndReadFile.readFromFile();
        mergeSort(a, 0, 99);
        WriteAndReadFile.show(a);
    }

}
