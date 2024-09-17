package test.leetcode2024;

import test.entry.ListNode;

/**
 * 旋转链表
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        rotateRight(listNode,2);

    }
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode listNode = head;
        int len = 0;
        while (listNode != null) {
            len++;
            listNode = listNode.next;
        }
        if (len == 0) {
            return head;
        }
        int flag = k % len;
        if (flag == 0) {
            return head;
        }
        ListNode node = new ListNode();
        ListNode pre = node;
        ListNode node1 = new ListNode();
        ListNode cur = node1;
        while (head != null) {
            ListNode listNode1 = new ListNode(head.val);
            if (flag >= len) {
                cur.next = listNode1;
                cur = cur.next;
            } else {
                pre.next = listNode1;
                pre = pre.next;
            }
            head = head.next;
            flag++;
        }
        cur.next = node.next;
        return node1.next;
    }
}
