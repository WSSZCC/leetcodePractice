package test.leetcode2024;

import test.entry.ListNode;

/**
 *  删除链表中的节点
 */
public class DeleteNode237 {

    public void deleteNode(ListNode node) {
        while (node.next!=null){
            ListNode next = node.next;
            node.val = next.val;
            if(node.next.next==null){
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}
