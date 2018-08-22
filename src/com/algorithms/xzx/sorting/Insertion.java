package com.algorithms.xzx.sorting;

import com.algorithms.xzx.file.WriteAndReadFile;

/**
 * @outhor 智祥
 * @create 2018-08-21 18:24
 */
public class Insertion {

    public static void sort(int[] a) {
        // 升序
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int T = a[j];
                a[j] = a[j - 1];
                a[j - 1] = T;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = WriteAndReadFile.readFromFile();
        //WriteAndReadFile.show(a);
        // System.out.println("");
        sort(a);
        WriteAndReadFile.show(a);
    }
}
