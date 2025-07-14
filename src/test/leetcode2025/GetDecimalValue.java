package test.leetcode2025;

import test.entry.ListNode;

/**
 * 二进制链表转整数
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head!=null){
            ans<<=1;
            ans+=head.val;
            head = head.next;
        }
        return ans;

    }
}
