package test.util;

import test.entry.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArrayToTree {
    public  static  TreeNode arrayToTree(List<Integer> array) {
        if (array.isEmpty()) return null;

        TreeNode root = new TreeNode(array.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1; // 数组索引
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 遍历当前层的每个节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 若数组中还有元素，则创建左子节点
                if (index < array.size() && array.get(index) != null) {
                    node.left = new TreeNode(array.get(index));
                    queue.offer(node.left);
                }
                index++;
                // 若数组中还有元素，则创建右子节点
                if (index < array.size() && array.get(index) != null) {
                    node.right = new TreeNode(array.get(index));
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }
}
