package test.leetcode2024;

import test.entry.ListNode;

/**
 * 删除链表的中间节点
 */
public class DeleteMiddle {


    public ListNode deleteMiddle(ListNode head) {
        ListNode node = head;
        if(head==null){
            return null;
        }
        int n = 0;
        while (node!=null){
            node = node.next;
            n++;
        }
        int i = n / 2;
        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        ListNode cur = head;
        while (i>=0){
            if(i==0){
               pre.next = cur.next;
            }else {
                ListNode listNode = cur.next;
                ListNode listNode1 = new ListNode(cur.val);
                pre.next = listNode1;
                pre = listNode1;
                cur = listNode;
            }
            i--;
        }
        return newHead.next;
    }
}
