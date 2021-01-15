package com.pipi.xzx.test2013;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/15 18:58
 **/

public class KruskalGraph {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int M = inScanner.nextInt(); // 点数
            int N = inScanner.nextInt(); // 连接数
            int[][] graph = new int[M][M]; // 邻接矩阵图
            Edge[] edges = new Edge[N];
            for (int i = 0; i < N; i++) {
                int head = inScanner.nextInt(); // 起点
                int tail = inScanner.nextInt(); // 尾点
                int cost = inScanner.nextInt(); // 该点成本
                graph[head - 1][tail - 1] = cost; // 无向图
                graph[tail - 1][head - 1] = cost;
                Edge edge = new Edge(head - 1, tail - 1, cost);
                edges[i] = edge; // 生成边集
            }
            // 填充图的数据
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == j)
                        continue;
                    else if (graph[i][j] > 0)
                        continue;
                    else
                        graph[i][j] = Integer.MAX_VALUE;
                }
            }
            int minCost = getMinCostByKruskal(graph, edges);
            if (minCost > 0)
                System.out.println(minCost);
            else
                System.out.println("?");
        }
    }

    public static int getMinCostByKruskal(int[][] Graph, Edge[] edges) {

        int[] father = new int[Graph.length]; // 并查集的father数组
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        Arrays.sort(edges); // 边集排序
        int cnt = 1; // 记录纳入的点数
        int sum = 0; // 计算纳入边和
        for (Edge e : edges) {
            // 查找起点和终点是否在同一个并查集
            int from = find(e.getFrom(), father);
            int to = find(e.getTo(), father);
            if (from != to) {
                // 如果不是，则纳入同一个并查集并计入
                merge(from, to, father);
                sum += e.getCost(); // 纳入最小路径
                cnt++;
            }
        }

        return cnt == Graph.length ? sum : -1;
    }

    /**
     * 并查集的查找函数
     *
     * @param x
     * @param father
     * @return
     */
    public static int find(int x, int[] father) {
        return x == father[x] ? x : find(father[x], father);
    }

    public static void merge(int i, int j, int[] father) {
        father[find(i, father)] = find(j, father);
    }

    // 边类，实现 comparable接口，方便排序
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public Edge() {

        }

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return this.from + "\t" + this.to + "\t" + this.cost;
        }

    }

}
