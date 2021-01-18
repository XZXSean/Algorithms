package com.pipi.xzx.test2014;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/18 18:39
 **/

public class SafePath {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int n = inScanner.nextInt();
            // 生成图的数据
            double[][] graph = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = inScanner.nextDouble();
                }
            }
            FloydSafe(graph); // 更新路径安全度
            for (double[] ds : graph) {
                System.out.println(Arrays.toString(ds));
            }
            int m = inScanner.nextInt(); // 要旅游的线路
            for (int i = 0; i < m; i++) {
                int from = inScanner.nextInt() - 1;
                int to = inScanner.nextInt() - 1;
                double safe = graph[from][to];
                if (safe == 0) {
                    System.out.println("What a pity!");
                } else {
                    System.out.printf("%.3f\n", safe);
                }
            }
        }
    }

    /**
     * 用弗洛伊德算法实现求最大安全度：时间超限50%
     *
     * @param Graph
     */
    public static void FloydSafe(double[][] Graph) {
        int len = Graph.length;
        for (int k = 0; k < len; k++) { // 以 k 为中转点
            for (int i = 0; i < len; i++) { // 遍历以 i 为行号， j 为列号的矩阵
                for (int j = 0; j < len; j++) {
                    if (Graph[i][j] < Graph[i][k] * Graph[k][j]) {
                        Graph[i][j] = Graph[i][k] * Graph[k][j];  // 更新安全度
                    }
                }
            }
        }
    }

}
