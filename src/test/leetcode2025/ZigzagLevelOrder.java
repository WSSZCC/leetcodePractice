package test.leetcode2025;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagLevelOrder {
    List<List<Integer>> list;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0, 1);
        return list;
    }

    private void dfs(TreeNode root, int i, int flag) {
        if (root == null) {
            return;
        }
        List<Integer> list1 = null;
        if (list.size() <= i) {
            list.add(new ArrayList<>());
        }
        list1 = list.get(i - 1);
        if(flag==1) {
            list1.add(root.val);
        }else {
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(root.val);
            list2.addAll(list1);
            list1 = list2;
        }
        list.set(i, list1);
        if (root.left != null) {
            dfs(root.left, i + 1, -flag);
        }
        if (root.right != null) {
            dfs(root.right, i + 1, -flag);
        }
    }
}
