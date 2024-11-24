package test.leetcode2024;

import test.entry.TreeNode;

/**
 * 二叉树展开为链表
 */
public class Flatten {

    TreeNode node = new TreeNode();
    TreeNode tree = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        tree = node;
        dfs(root);
        root.right = node.right.right;
        root.left = null;

    }

    private void dfs(TreeNode root) {
        TreeNode right = root.right;
        TreeNode left = root.left;
        tree.right = new TreeNode(root.val);
        tree = tree.right;
        if (left != null) {
            dfs(left);
        }
        if (right != null) {
            dfs(right);
        }
    }


}
