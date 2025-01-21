package test.leetcode2024;

import test.entry.ListNode;

/**
 * 重排链表
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2!=null&&node2.next!=null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if(node2!=null){
            node2 = new ListNode(node1.val);
            node1 = node1.next;
        }
        ListNode listNode = null;
        while (node1!=null){
            ListNode next = node1.next;
            node1.next = listNode;
            listNode = node1;
            node1 = next;
        }
        ListNode node3 = head;
        while (listNode!=null){
            ListNode next = node3.next;
            ListNode next1 = listNode.next;
            listNode.next = null;
            node3.next = listNode;
            node3 = node3.next;
            if(next1!=null) {
                node3.next = next;
                node3 = node3.next;
            }
            listNode = next1;


        }
        if(node2!=null){
            node3.next = node2;
        }
    }
}
