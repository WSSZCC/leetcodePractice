package test.leetcode2024;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 */
public class PathSum {
    List<List<Integer>> targetList;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        targetList = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>());
        return targetList;
    }

    private void dfs(TreeNode root, int currentSum, int targetSum, List<Integer> currentList) {
        if (root != null) {
            currentList.add(root.val);
            if (root.right == null && root.left == null) {
                if (currentSum + root.val == targetSum) {

                    targetList.add(new ArrayList<>(currentList));
                    return;
                }
            }
            if (root.left != null) {
                dfs(root.left, currentSum + root.val, targetSum, new ArrayList<>(currentList));
            }
            if (root.right != null) {
                dfs(root.right, currentSum + root.val, targetSum, new ArrayList<>(currentList));
            }
        }

    }
}
