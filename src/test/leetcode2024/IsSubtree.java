package test.leetcode2024;

import test.entry.TreeNode;
import test.util.ArrayToTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 另一棵树的子树
 */
public class IsSubtree {
    public static void main(String[] args) {
        TreeNode treeNode = ArrayToTree.arrayToTree(Arrays.asList( 3,4,5,1,2));
        TreeNode treeNode2 = ArrayToTree.arrayToTree(Arrays.asList(4,1,2));
        isSubtree(treeNode, treeNode2);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == subRoot.val) {
                Deque<TreeNode[]> curQueue = new LinkedList<>();
                Deque<TreeNode[]> tarQueue = new LinkedList<>();
                if (subRoot.left != null) {
                    tarQueue.add(new TreeNode[]{subRoot.left, new TreeNode(1)});
                }
                if (subRoot.right != null) {
                    tarQueue.add(new TreeNode[]{subRoot.right, new TreeNode(-1)});
                }
                if (poll.left != null) {
                    curQueue.add(new TreeNode[]{poll.left, new TreeNode(1)});
                }
                if (poll.right != null) {
                    curQueue.add(new TreeNode[]{poll.left, new TreeNode(-1)});
                }
                while (!curQueue.isEmpty()) {
                    TreeNode[] poll1 = curQueue.peek();
                    TreeNode[] poll2 = tarQueue.poll();
                    if (poll2 == null || poll1[0].val != poll2[0].val || poll1[1].val != poll2[1].val) {
                        break;
                    }
                    curQueue.poll();
                    if (poll2[0].left != null) {
                        tarQueue.add(new TreeNode[]{poll2[0].left,new TreeNode(poll2[1].val+1)});
                    }
                    if (poll2[0].right != null) {
                        tarQueue.add(new TreeNode[]{poll2[0].right,new TreeNode(poll2[1].val-1)});
                    }
                    if (poll1[0].left != null) {
                        curQueue.add(new TreeNode[]{poll1[0].left,new TreeNode(poll1[1].val+1)});
                    }
                    if (poll1[0].right != null) {
                        curQueue.add(new TreeNode[]{poll1[0].right,new TreeNode(poll1[1].val-1)});
                    }
                }
                if (curQueue.isEmpty() && tarQueue.isEmpty()) {
                    return true;
                }
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }

        }
        return false;
    }
}
