package test.leetcode2024;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 */
public class LevelOrder {
    List<List<Integer>> list;

    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 1);
        return list;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (list.size() < index) {
            list.add(new ArrayList<>());
        }
        List<Integer> integers = list.get(index - 1);
        integers.add(root.val);
        list.set(index-1,integers);
        dfs(root.left,index+1);
        dfs(root.right,index+1);
    }
}
