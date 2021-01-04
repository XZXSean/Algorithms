package com.leetcode.xzx.array;

import java.util.Arrays;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/3 12:19
 **/

public class LeetCodeArr {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        System.out.println("原数组：");
        showTwoMatrix(matrix);
        rotate(matrix);
    }

    /**
     * 旋转图像: https://leetcode-cn.com/problems/rotate-image/
     * <p>
     * 实现思路：
     * 1. 数组转置；
     * 2. 第 i 列与第 n-i 列互换
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        reverseMatrix(matrix);  // 先将数组进行转置
        System.out.println("数组转置：");
        showTwoMatrix(matrix);
        // 列交换
        int column = matrix[0].length;
        for (int i = 0; i < column / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][column - i - 1];
                matrix[j][column - i - 1] = temp;
            }
        }
        // 列交换：
        showTwoMatrix(matrix);
        /* // 行交换
        int[] temp;
        for (int i = 0; i < matrix.length / 2; i++) {
            temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }*/
    }

    /**
     * 数组转置
     *
     * @param matrix
     */
    public static void reverseMatrix(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) { // 转置矩阵
            for (int j = 0; j < i; j++) {   // 遍历下三角，交换
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void showTwoMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
