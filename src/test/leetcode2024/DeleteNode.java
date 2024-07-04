package test.leetcode2024;

import test.entry.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除二叉搜索树中的节点
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode right = root.right;
        while (right.left != null) {
            right = right.left;
        }
        root.right = deleteNode(root.right, right.val);
        right.left = root.left;
        right.right = root.right;
        return right;
    }
}
