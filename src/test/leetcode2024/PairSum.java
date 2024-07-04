package test.leetcode2024;

import test.entry.ListNode;

/**
 * 链表最大孪生和
 */
public class PairSum {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        pairSum(listNode);
    }
    public static int pairSum(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode pre = listNode;
        ListNode cur = head;
        ListNode slow = head;
        while (cur!=null){
            ListNode node = cur.next.next;
            ListNode listNode1 = new ListNode(slow.val);
            pre.next = listNode1;
            pre = listNode1;
            slow = slow.next;
            cur = node;
        }
        ListNode node = null;
        while (slow!=null){
            ListNode next = slow.next;
            slow.next=node;
            node = slow;
            slow = next;
        }
        int maxPairSum = 0;
        listNode = listNode.next;
        while (node!=null){
           maxPairSum = Math.max(maxPairSum,node.val+listNode.val);
           listNode = listNode.next;
           node = node.next;
        }
        return maxPairSum;
    }
}
