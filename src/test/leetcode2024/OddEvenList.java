package test.leetcode2024;

import test.entry.ListNode;

/**
 * 奇偶链表
 */
public class OddEvenList {
    public static void main(String[] args) {

    }
    public ListNode oddEvenList(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode pre = listNode;
        ListNode cur = head;
        while (cur!=null&&cur.next!=null&&cur.next.next!=null){
            ListNode next = cur.next.next;
            ListNode listNode1 = new ListNode(cur.val);
            pre.next = listNode1;
            pre = listNode1;
            cur = next;
        }
        if(cur!=null){
            ListNode listNode1 = new ListNode(cur.val);
            pre.next = listNode1;
            pre = listNode1;
        }
        ListNode cur1 = head.next;
        while (cur1!=null&&cur1.next!=null&&cur1.next.next!=null){
            ListNode next = cur1.next.next;
            ListNode listNode1 = new ListNode(cur1.val);
            pre.next = listNode1;
            pre = listNode1;
            cur1 = next;
        }
        if(cur1!=null){
            ListNode listNode1 = new ListNode(cur1.val);
            pre.next = listNode1;
            pre = listNode1;
        }
        return listNode.next;
    }
}
