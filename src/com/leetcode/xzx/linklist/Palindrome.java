package com.leetcode.xzx.linklist;

import java.util.ArrayList;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/6 17:54
 **/

public class Palindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
        ;
    }

    /**
     * 判断是否回文链表
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode L = new ListNode();
        L.next = head; // 增加一个头结点，方便计算
        ListNode slow = L, fast = L;
        int cnt = 0; // cnt 为链表长度的一半
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            cnt++;
            arrayList.add(slow.val);
        }
//        System.out.println(cnt + "\t" + arrayList.toString() + "\t" + arrayList.get(2));
        cnt = fast == null ? cnt - 1 : cnt; // 偶数项还是奇数项,如果是奇数项，先向后退一位
        slow = slow.next; // 后半段与前半段来进行回文判断
        while (slow != null) {
            if (arrayList.get(--cnt) != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }
}
