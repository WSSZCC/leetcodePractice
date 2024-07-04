package test.leetcode2024;

import test.entry.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中的搜索
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.pollLast();
            int val1 = treeNode.val;
            if(val1==val){
                return treeNode;
            }
            if(val1>val&&treeNode.left!=null){
                deque.add(treeNode.left);
            }
            if(val1<val&&treeNode.right!=null){
                deque.add(treeNode.right);
            }
        }
        return null;
    }
}
