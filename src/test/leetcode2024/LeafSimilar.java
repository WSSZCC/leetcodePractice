package test.leetcode2024;

import test.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 */
public class LeafSimilar {
    public static void main(String[] args) {

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        dfs(root2,list2);
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root.right==null&&root.left==null){
            list.add(root.val);
            return;
        }
        if(root.right!=null){
            dfs(root.right,list);
        }
        if(root.left!=null){
            dfs(root.left,list);
        }
    }
}
