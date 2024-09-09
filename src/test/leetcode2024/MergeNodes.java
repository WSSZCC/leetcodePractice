package test.leetcode2024;

import test.entry.ListNode;

/**
 *  合并零之间的节点
 */
public class MergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;
        int value = 0;
        boolean isChange = false;
        head = head.next;
        while (head!=null){
            if(head.val==0){
                if(isChange) {
                    pre.next = new ListNode(value);
                    pre = pre.next;
                }
                value = 0;
                isChange = false;
            }else {
                isChange = true;
                value+=head.val;
            }
            head = head.next;
        }
        return listNode.next;
    }
}
