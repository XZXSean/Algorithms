package com.algorithms.xzx.sorting;

import com.algorithms.xzx.file.WriteAndReadFile;

/**
 * @outhor 智祥
 * @create 2018-08-22 16:07
 */
public class Shell {


    public static void sort(int[] a) {
        // 升序
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int T = a[j];
                    a[j] = a[j - h];
                    a[j - h] = T;
                }
            }
            h = h / 3;
        } // end-of-while
    }

    public static void main(String[] args) {
        int[] a = WriteAndReadFile.readFromFile();
        sort(a);
        WriteAndReadFile.show(a);
    }
}
