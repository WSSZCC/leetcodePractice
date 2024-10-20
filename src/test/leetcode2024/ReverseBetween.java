package test.leetcode2024;

import test.entry.ListNode;

/**
 * 反转链表 II
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode node = new ListNode();
        ListNode temp = null;
        ListNode pre = node;
        ListNode cur = head;
        int count = 1;
        while (cur != null) {
            if (count > right) {
                break;
            }
            if(count>=left){
                ListNode listNode = new ListNode(cur.val);
                listNode.next = temp;
                temp = listNode;
            }else {
                pre.next = new ListNode(cur.val);
                pre = pre.next;
            }
            count++;
            cur = cur.next;
        }
        while (temp!=null){
            pre.next = new ListNode(temp.val);
            temp = temp.next;
            pre = pre.next;
        }
        if(cur!=null){
            pre.next = cur;
        }
        return node.next;
    }
}
