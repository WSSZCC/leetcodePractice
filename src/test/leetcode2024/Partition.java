package test.leetcode2024;

import test.entry.ListNode;

/**
 * 分隔链表
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode node = new ListNode();
        ListNode node1 = new ListNode();
        ListNode offset = node1;
        ListNode pre = node;
        while (head!=null){
            if(head.val<x){
                pre.next = new ListNode(head.val);
                pre = pre.next;
            }else {
                offset.next = new ListNode(head.val);
                offset = offset.next;
            }
            head = head.next;
        }
        pre.next = node1.next;
        return node.next;
    }
}
