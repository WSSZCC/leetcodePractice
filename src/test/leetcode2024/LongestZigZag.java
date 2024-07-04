package test.leetcode2024;

import test.entry.TreeNode;
import test.util.ArrayToTree;

import java.util.Arrays;

/**
 * 二叉树中的最长交错路径
 */
public class LongestZigZag {
    public static void main(String[] args) {
        TreeNode treeNode = ArrayToTree.arrayToTree(Arrays.asList(1,1,1,null,1,null,null,1,1,null,1));
        longestZigZag(treeNode);
    }

    static int maxLen;

    public static int longestZigZag(TreeNode root) {
        maxLen = 0;
        if (root == null || (root.left == null && root.right == null)) {
            return maxLen;
        }
        if (root.left != null) {
            dfs(root.left, 1, false);
        }
        if(root.right!=null) {
            dfs(root.right, 1, true);
        }
        return maxLen;
    }

    private static void dfs(TreeNode root, int i, boolean isLeft) {
        if (root.left == null && root.right == null) {
            maxLen = Math.max(maxLen, i);
            return;
        }
        if (root.right != null) {
            if(root.left==null&&isLeft){
                maxLen = Math.max(maxLen,i);
            }
            dfs(root.right, isLeft ? 1 : i + 1, true);
        }
        if (root.left != null) {
            if(root.right==null&&!isLeft){
                maxLen = Math.max(maxLen,i);
            }
            dfs(root.left, isLeft ? i + 1 : 1, false);
        }
    }
}
