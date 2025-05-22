package test.leetcode2025;

import test.entry.TreeNode;

/**
 * 求和路径
 */
public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = pathSum1(root, sum);
        count += pathSum1(root.left, sum);
        count += pathSum1(root.right, sum);
        return count;
    }

    private int pathSum1(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        int val = root.val;
        if (val == sum) {
            count++;
        }
        count+=pathSum1(root.left,sum-val);
        count+=pathSum1(root.right,sum-val);
        return count;
    }
}
