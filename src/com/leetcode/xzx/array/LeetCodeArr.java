package com.leetcode.xzx.array;

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
        showTwoMatrix(matrix);
        rotate(matrix);
        showTwoMatrix(matrix);
    }


    /**
     * 旋转图像: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) { // 行
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
    }
}
