package test.leetcode2024;

import test.entry.ListNode;

/**
 * 对链表进行插入排序
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode listNode = new ListNode(head.val);
        head = head.next;
        while (head!=null){
            if(listNode.val<head.val){
                ListNode node = listNode;
                while (true){
                    if(node.next==null||node.next.val>head.val){
                        ListNode node1 = node.next;
                        node.next = new ListNode(head.val);
                        node = node.next;
                        node.next = node1;
                        break;
                    }
                    node = node.next;
                }
            }else {
                ListNode listNode1 = new ListNode(head.val);
                listNode1.next = listNode;
                listNode = listNode1;
            }
            head = head.next;
        }
        return listNode;
    }
}
