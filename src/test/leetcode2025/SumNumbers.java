package test.leetcode2025;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶节点数字之和
 */
public class SumNumbers {
    static List<Integer> list;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        sumNumbers(treeNode);
    }

    public static int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            dfs(root, 0);
        }
        return list.stream().mapToInt(a -> a).sum();
    }

    private static void dfs(TreeNode root, int i) {
        if (root.right == null && root.left == null) {
            list.add(i * 10 + root.val);
            return;
        }
        if(root.left!=null) {
            dfs(root.left, i * 10 + root.val);
        }
        if(root.right!=null) {
            dfs(root.right, i * 10 + root.val);
        }
    }
}
