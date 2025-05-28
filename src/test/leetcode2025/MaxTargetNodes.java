package test.leetcode2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 连接两棵树后最大目标节点数目 I
 */
public class MaxTargetNodes {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
      int max1 = 0;
      if(k>0){
          List<Integer>[] lists = build(edges2);
          for (int i = 0; i <= edges2.length; i++) {
              max1 = Math.max(max1,dfs(i,-1,0,lists,k-1));
          }
      }
        List<Integer>[] lists = build(edges1);
        int[] ints = new int[edges1.length + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = dfs(i,-1,0,lists,k)+max1;
        }
        return ints;

    }

    private int dfs(int a, int b, int c, List<Integer>[] lists, int k) {
        if(c>k){
            return 0;
        }
        int ans = 1;
        for (Integer integer : lists[a]) {
            if(integer!=b){
                ans+=dfs(integer,a,c+1,lists,k);
            }
        }
        return ans;
    }

    private List<Integer>[] build(int[][] edges2) {
        List<Integer>[] lists = new ArrayList[edges2.length + 1];
        Arrays.setAll(lists,i->new ArrayList<>());
        for (int[] ints : edges2) {
            int i = ints[0];
            int j = ints[1];
            lists[i].add(j);
            lists[j].add(i);
        }
        return lists;
    }
}
