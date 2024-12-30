package test.leetcode2024;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BaseSchemaDVFactory;
import test.entry.ListNode;
import test.entry.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树中的链表
 */
public class IsSubPath {

    boolean isTrue;
    public boolean isSubPath(ListNode head, TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode poll = list.poll();
            isTrue = false;
            if(poll.val==head.val){
                dfs(head,poll);
                if(isTrue){
                    return true;
                }
            }
            if(poll.left!=null){
                list.add(poll.left);
            }
            if(poll.right!=null){
                list.add(poll.right);
            }
        }
        return false;
    }

    private void dfs(ListNode head, TreeNode root) {
        if(head==null||isTrue){
            isTrue = true;
            return;
        }
        if(root==null||head.val!=root.val){
            return;
        }
        dfs(head.next,root.right);
        dfs(head.next,root.left);
    }
}
