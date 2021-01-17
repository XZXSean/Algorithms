package com.pipi.xzx.test2014;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/17 18:18
 **/

public class MaxSubSequence {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int cnt = inScanner.nextInt();
            int[] nums = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                nums[i] = inScanner.nextInt();
            }
            getMaxSubSequence(nums);
            getMaxSubSequence2(nums);
        }
    }

    /**
     * 动态规划解决
     *
     * @param nums
     */
    public static void getMaxSubSequence2(int[] nums) {
        Node[] nodes = new Node[nums.length]; // 新建记录到i的最大值数组
        // 添加第一个位置
        Node first = new Node();
        first.from = 0;
        first.to = 0;
        first.value = nums[0];
        nodes[0] = first;
        Node last = first; // 上一个最大位置
        Node current; // 当前位置
        for (int i = 1; i < nums.length; i++) { // 从第二个位置开始
            current = new Node();
            if (nums[i] + last.value > nums[i]) { // 前一个最大序列与当前位置之和大于当前位置，则将当前位置纳入最大子序列计算
                current.from = last.from;
                current.to = i;
                current.value = nums[i] + last.value;
            } else { // 否则从当前位置从新计算
                current.from = i;
                current.to = i;
                current.value = nums[i];
            }
            last = current; // 更新上一个的最大子序列
            nodes[i] = current;
        }
        Arrays.sort(nodes);
//        for (Node n :nodes) {
//            System.out.println(n.toString());
//        }
        Node node = nodes[nodes.length - 1];
        if (node.value < 0) System.out.println("0 0 0");
        else System.out.println(node.value + " " + node.from + " " + node.to);
    }

    /**
     * 暴力解决：
     * 对于每一个位置 i，分别计算前 1项，2项， 。。。  前 i项之和，找出最大的和，记录是前几项
     * 实现Comparable接口，方便排序，先按 value 排序，若相同，按 from 逆序排序，最后按 to 逆序排序
     *
     * @param nums
     */
    public static void getMaxSubSequence(int[] nums) {
        Node[] nodes = new Node[nums.length];
        Node node;
        for (int i = 0; i < nums.length; i++) { // 计算每一个位置的最大值
            int sum = Integer.MIN_VALUE;
            int j = 0, max_pos = 0;
            for (; j <= i; j++) { // 依次计算 j -> i上每一个位置到 i的最大值
                int temp = 0, k = j;
                for (; k <= i; k++) { // j -> i 的最大值
                    temp += nums[k];
                }
                if (temp > sum) {
                    max_pos = j;
                    sum = temp;
                }
            }
            node = new Node();
            node.from = max_pos;
            node.to = i;
            node.value = sum;
            nodes[i] = node;
        }
        Arrays.sort(nodes);
//        for (Node n :nodes) {
//            System.out.println(n.toString());
//        }
        node = nodes[nodes.length - 1];
        if (node.value < 0) System.out.println("0 0 0"); // 若小于0，直接输出 0 0 0
        else System.out.println(node.value + " " + node.from + " " + node.to);
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int value;

        @Override
        public String toString() {
            return "from = " + from + "\t to = " + to + "\t value = " + value;
        }

        // 实现Comparable接口，方便排序，先按 value 排序，若相同，按 from 逆序排序，最后按 to 逆序排序
        @Override
        public int compareTo(Node o) {
            if (this.value != o.value) return this.value - o.value;
            else if (this.from != o.from) return o.from - this.from;
            else return o.to - this.to;
        }

    }

}
