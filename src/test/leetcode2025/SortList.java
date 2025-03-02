package test.leetcode2025;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import test.entry.ListNode;

import java.util.PriorityQueue;

/**
 * 148. 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode suffix = mid.next;
        mid.next = null;
        ListNode listNode1 = sortList(suffix);
        ListNode listNode2 = sortList(head);
        return mergeList(listNode1,listNode2);
    }

    private ListNode mergeList(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = new ListNode();
        ListNode cur = listNode;
        while (listNode1!=null&&listNode2!=null){
            if(listNode1.val<listNode2.val){
                cur.next = listNode1;
                listNode1 = listNode1.next;
            }else {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            }
            cur = cur.next;
        }
        cur.next = listNode1==null?listNode2:listNode1;
        return listNode.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode cur = head;
        ListNode temp = head;
        while (temp!=null&&temp.next!=null&&temp.next.next!=null){
            cur = cur.next;
            temp = temp.next.next;
        }
        return cur;
    }

    /**
     * 最low的写法
     *
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode cur = head;
        while (cur != null) {
            queue.add(cur.val);
            cur = cur.next;
        }
        ListNode temp = head;
        while (!queue.isEmpty()) {
            temp.val = queue.poll();
            temp = temp.next;
        }
        return head;
    }
}
