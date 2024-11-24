package test.leetcode2024;

import test.entry.TreeNode;

/**
 * 二叉树展开为链表
 */
public class Flatten {

    TreeNode node = new TreeNode();
    int count = 0;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode tree = node;
        dfs(tree,root);
        root.right = node.right;
        root.left = null;

        while (node!=null){
            System.out.println(node.val);
            node = node.right;
        }

    }

    private void dfs(TreeNode tree,TreeNode root) {
        TreeNode right = root.right;
        TreeNode left = root.left;
        tree.right = new TreeNode(root.val);
        tree.left = null;
        tree = tree.right;
        printNode();
        if(left!=null){
            dfs(tree,left);
        }
        if(right!=null){
            dfs(tree,right);
        }
    }

    private void printNode() {
        TreeNode node1 = node;
        count++;
        System.out.println("---------"+count+"--------");
        while (node1!=null){
            System.out.println(node1.val);
            node1 = node1.right;
        }
    }


}
