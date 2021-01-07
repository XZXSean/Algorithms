package com.leetcode.xzx.tree;

import java.util.*;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/6 21:01
 **/

public class TreeDepth {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
//        treeNode.left.left = new TreeNode(1);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        TreeNode.LevelOrderShow(treeNode);
//        System.out.println(isValidBST(treeNode));
        List<List<Integer>> lists = levelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
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

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        if (root == null) return tree;
        List<Integer> level = new ArrayList<>(); // 某一层
        Queue<TreeNode> queue = new LinkedList<>(); // 遍历队列
        queue.offer(root);
        int levelSize = 0; // 当前某一层的节点个数
        TreeNode node;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            while (levelSize > 0) {
                node = queue.poll();
                if (node != null) {
                    level.add(node.val); // 访问该节点
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                levelSize--;
            }
            if (!level.isEmpty()) tree.add(level);
            level = new ArrayList<>();
        }
        return tree;
    }

}
