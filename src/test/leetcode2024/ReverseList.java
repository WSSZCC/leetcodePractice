package test.leetcode2024;

import test.entry.ListNode;

public class ReverseList {


    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = new ListNode(2,null);
        reverseList(listNode);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode();
        while (head!=null){
            ListNode listNode1 = new ListNode(head.val,null);
            head = head.next;
            if(listNode.next!=null){
                listNode1.next = listNode.next;
            }
            listNode.next = listNode1;

        }
        return listNode;
    }

}
