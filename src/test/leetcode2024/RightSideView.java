package test.leetcode2024;

import test.entry.TreeNode;
import test.util.ArrayToTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的右视图
 */
public class RightSideView {
    public static void main(String[] args) {
        TreeNode treeNode = ArrayToTree.arrayToTree(Arrays.asList(1, 2, 3, null, 5, null,null ,4));
        rightSideView(treeNode);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        dfs(root,list,0);
        return list;
    }

    private static void dfs(TreeNode root, List<Integer> list, int dept) {
        if(root==null){
            return;
        }
        if(list.size()<=dept){
            list.add(root.val);
        }else {
            list.set(dept, root.val);
        }
        dept++;
        dfs(root.left,list,dept);
        dfs(root.right,list,dept);
    }
}
