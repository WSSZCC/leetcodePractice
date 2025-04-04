package test.leetcode2025;

import test.entry.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 */
public class LcaDeepestLeaves {
    private int maxDept;
    TreeNode treeNode;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDept = -1;
        treeNode = new TreeNode();
        dfs(root, 0);
        return treeNode;
    }

    private int dfs(TreeNode root, int dept) {
        if (root == null) {
            maxDept = Math.max(maxDept, dept);
            return dept;
        }
        int left = dfs(root.left, dept + 1);
        int right = dfs(root.right, dept + 1);
        if (left == right) {
            treeNode = root;
        }
        return Math.max(left,right);
    }
}
