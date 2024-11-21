package test.leetcode2024;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {
    private List<Integer> list;
    private int index;
    private int maxIndex;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        maxIndex = list.size();
        index = 0;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public int next() {
        Integer integer = list.get(index);
        index++;
        return integer;
    }

    public boolean hasNext() {
        return index<maxIndex;
    }
}
