package test.leetcode2025;

import test.entry.TreeNode;

import java.util.Stack;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n==0){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        int flag = 0;
        for (int i = 1; i < n; i++) {
            int value = preorder[i];
            TreeNode pop = stack.peek();
            if(pop.val!=inorder[flag]){
                pop.left = new TreeNode(value);
                stack.push(pop.left);
            }else {
                while (!stack.isEmpty()&&stack.peek().val==inorder[flag]){
                    pop = stack.peek();
                    stack.pop();
                    flag++;
                }
                pop.right = new TreeNode(value);
                stack.push(pop.right);
            }
        }
        return treeNode;

    }
}
