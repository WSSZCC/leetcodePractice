package test.leetcode2024;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 III
 */
public class PathSum3 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1000000000);
        treeNode.left = new TreeNode(1000000000);
        treeNode.left.left = new TreeNode(294967296);
        treeNode.left.left.left = new TreeNode(294967296);
        treeNode.left.left.left.left = new TreeNode(1000000000);
        treeNode.left.left.left.left.left = new TreeNode(1000000000);
        pathSum(treeNode,0);
    }
    static Integer allPathSum;
    public static int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        allPathSum = 0;
        dfs(root,new ArrayList<>(),targetSum);
        return allPathSum;
    }

    private static void dfs(TreeNode root, List<Long> pathList, int targetSum) {
        if(root.val==targetSum){
            allPathSum++;
        }
        if(!pathList.isEmpty()){
            for (int i = 0; i < pathList.size(); i++) {
                long sum = root.val + pathList.get(i);
                if(sum==targetSum){
                    allPathSum++;
                }
                pathList.set(i,sum);
            }
        }
        pathList.add((long) root.val);
        if(root.right==null&&root.left==null){
            return;
        }
        if(root.right!=null){
            dfs(root.right,new ArrayList<>(pathList), targetSum);
        }
        if(root.left!=null){
            dfs(root.left,new ArrayList<>(pathList), targetSum);
        }
    }
}
