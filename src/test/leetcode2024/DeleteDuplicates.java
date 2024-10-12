package test.leetcode2024;

import test.entry.ListNode;

/**
 * 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode();
        if(head==null){
            return null;
        }
        ListNode cur = node;
        ListNode pre = head;
        int value = head.val;
        boolean isSame = false;
        while (pre.next!=null){
            if(pre.next.val!=value){
                if(!isSame){
                    cur.next = new ListNode(value);
                    cur = cur.next;
                }
                value = pre.next.val;
                pre = pre.next;
                isSame = false;
                continue;
            }
            isSame = true;
            pre = pre.next;
        }
        if(!isSame){
            cur.next = new ListNode(value);
        }
        return node.next;
    }
}
