package test.leetcode2025;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历 II
 */
public class LevelOrderBottom {
    List<List<Integer>> list;
    int n;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        list = new ArrayList<>();
        n = 0;
        dfs(root, 0);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        dfs1(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) {
            n = Math.max(i, n);
            return;
        }
        dfs(root.left, i + 1);
        dfs(root.right, i + 1);

    }

    private void dfs1(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        List<Integer> list1 = list.get(n - i - 1);
        list1.add(root.val);
        list.set(n - i - 1, list1);
        dfs1(root.left, i + 1);
        dfs1(root.left, i + 1);

    }
}
