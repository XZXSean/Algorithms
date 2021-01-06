package com.leetcode.xzx.linklist;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/5 20:11
 **/

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void showList() {
        ListNode listNode = this;
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.print("null\n");
    }
}
