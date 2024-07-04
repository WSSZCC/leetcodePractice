package test.leetcode2024;

import test.entry.TreeNode;

/**
 * 统计二叉树中好节点的数目
 */
public class GoodNodes {
    public static void main(String[] args) {

    }
    int n;
    public int goodNodes(TreeNode root) {
        n = 0;
        if(root==null){
           return n;
        }
        n++;
        dfs(root,root.val);
        return n;
    }

    private void dfs(TreeNode root, int val) {
        if(root.left==null&&root.right==null){
            return;
        }
        if(root.left!=null){
            if(root.left.val>=val){
                n++;
            }
            dfs(root.left,Math.max(root.left.val,val));
        }
        if(root.right!=null){
            if(root.right.val>=val){
                n++;
            }
            dfs(root.right,Math.max(root.right.val,val));
        }
    }
}
