package com.leetcode.xzx.linklist;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/6 18:36
 **/

public class CycleList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;
//        head.showList();
        System.out.println(hasCycle(head));
    }

    /**
     * 判断链表中是否有环存在
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode listNode = new ListNode();
        listNode.next = head; // 使用一个头节点方便计算
        ListNode slow = listNode, fast = listNode;
        int pos = 0; // 环的起始位置
        fast = fast.next.next;
        slow = slow.next;
        while (fast != null && fast.next != null && slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
            pos++;
        }
        return fast == slow;
    }
}
