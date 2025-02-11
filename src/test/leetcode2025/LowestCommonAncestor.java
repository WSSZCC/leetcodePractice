package test.leetcode2025;

import test.entry.TreeNode;

import java.util.LinkedList;

/**
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list = new LinkedList<>();
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            if (poll.val <= max && poll.val >= min) {
                return poll;
            }
            if (poll.val < min && poll.right != null) {
                list.add(poll.right);
            }
            if (poll.val > max && poll.left != null) {
                list.add(poll.left);
            }
        }
        return null;
    }

    private boolean checkValue(TreeNode root, int val) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            if (poll.val == val) {
                return true;
            }
            if (poll.val < val) {
                if (poll.right != null) {
                    list.add(poll.right);
                }
            } else {
                if (poll.left != null) {
                    list.add(poll.left);
                }
            }
        }
        return false;
    }
}
