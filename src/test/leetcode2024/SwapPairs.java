package test.leetcode2024;

import test.entry.ListNode;

/**
 * 两两交换链表中的节点
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        swapPairs(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode node = head;
        ListNode cur = listNode;
        while (node != null) {
            if (node.next == null) {
                cur.next =  node;
                break;
            }
            ListNode node1 = node;
            ListNode next = node.next;
            node1.next = null;
            node = next.next;
            next.next = node1;
            cur.next = next;
            cur = cur.next.next;
        }
        return listNode.next;
    }
}
