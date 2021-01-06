package com.leetcode.xzx.tree;

import java.util.Stack;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/6 21:01
 **/

public class TreeDepth {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(Integer.MIN_VALUE);
//        treeNode.left.left = new TreeNode(1);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);
        TreeNode.LevelOrderShow(treeNode);
        System.out.println(isValidBST(treeNode));
    }

    /**
     * 求树深
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }

    /**
     * 验证是否二叉排序树
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE; // 此处用long是用来避免同是Integer的最小值
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= min) {
                return false;
            }
            min = root.val;
            root = root.right;
        }
        return true;
    }
}
