package test.leetcode2024;

import test.entry.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *  二叉搜索树中第 K 小的元素
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        LinkedList<TreeNode> queue = new LinkedList<>();
        int flag = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (flag == k) {
                if(priorityQueue.peek()>poll.val){
                    priorityQueue.poll();
                    priorityQueue.add(poll.val);
                }
            } else {
                priorityQueue.add(poll.val);
                flag++;
            }
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }

        }
        return priorityQueue.peek();
    }
}
