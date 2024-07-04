package test.leetcode2024;

import org.omg.CORBA.INTERNAL;
import test.entry.TreeNode;
import test.util.ArrayToTree;

import java.util.*;

/**
 * 最大层内元素和
 */
public class MaxLevelSum {
    public static void main(String[] args) {
        maxLevelSum(ArrayToTree.arrayToTree(Arrays.asList(989,null,10250,98693,-89388,null,null,null,-32127)));
    }
    public static int maxLevelSum(TreeNode root) {
        List<Long> treeValues = new ArrayList<>();
        if(root==null){
            return 0;
        }
        Deque<TreeNode> treeNodes = new LinkedList<>();
        Deque<Integer> depths = new LinkedList<>();
        treeNodes.push(root);
        depths.push(1);
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.pollLast();
            Integer depth = depths.pollLast();
            if(treeValues.size()<depth){
                treeValues.add((long) node.val);
            }else {
                Long value = treeValues.get(depth-1) + node.val;
                treeValues.set(depth-1,value);
            }
            if(node.left!=null){
                treeNodes.push(node.left);
                depths.push(depth+1);
            }
            if(node.right!=null){
                treeNodes.push(node.right);
                depths.push(depth+1);
            }
        }
        int targetDepth = 0;
        long maxValue = treeValues.get(0);
        int n = treeValues.size();
        for (int i = 1; i < n; i++) {
            if(maxValue<treeValues.get(i)){
                maxValue = treeValues.get(i);
                targetDepth = i;
            }
        }
        return targetDepth;
    }
}
