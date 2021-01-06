package com.leetcode.xzx.linklist;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/5 20:42
 **/

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.showList();
        head = reverseList(head);
        head.showList();
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode L = new ListNode();
        L.next = null; // 加一个头结点
        ListNode temp;
        while (head != null) {
            temp = head.next; // 保存下一个节点
            head.next = L.next; // 将当前节点断开头插法插入L中
            L.next = head;
            head = temp;
        }
        return L.next;
    }
}
