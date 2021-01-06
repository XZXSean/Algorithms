package com.leetcode.xzx.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/6 21:00
 **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 层序遍历打印树
     *
     * @param T
     */
    public static void LevelOrderShow(TreeNode T) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(T);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) System.out.print("null\t");
            else {
                System.out.print(node.val + "\t");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
}
