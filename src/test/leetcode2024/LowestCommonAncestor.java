package test.leetcode2024;

import test.entry.TreeNode;
import test.util.ArrayToTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = ArrayToTree.arrayToTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer[]> map = new HashMap<>();
        dfs(root, map, null, 0);
        Integer[] integers = map.get(p.val);
        Integer[] integers1 = map.get(q.val);
        if (integers[0] == 1) {
            return p;
        }
        if (integers1[0] == 1) {
            return q;
        }
        if(integers[1] == q.val){
            return q;
        }
        if(integers1[1] == p.val){
            return p;
        }
        Integer qVal = q.val;
        while (qVal != null) {
            Integer[] pMapVal = new Integer[]{map.get(p.val)[0]+1,p.val};
            while (pMapVal[0] > 1) {
                if (pMapVal[1] == qVal) {
                    return new TreeNode(qVal);
                }
                pMapVal = map.get(pMapVal[1]);
            }
            qVal = map.get(qVal)[1];
        }
        return new TreeNode(root.val);
    }

    private static void dfs(TreeNode root, Map<Integer, Integer[]> map, Integer preVal, Integer dept) {
        if (root == null) {
            return;
        }
        dept++;
        map.put(root.val, new Integer[]{dept, preVal});
        dfs(root.left, map, root.val, dept);
        dfs(root.right, map, root.val, dept);
    }
}
