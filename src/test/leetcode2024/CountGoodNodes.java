package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计好节点的数目
 */
public class CountGoodNodes {
    private int ans;
    public int countGoodNodes(int[][] edges){
        int n = edges.length+1;
        List<Integer>[] lists = new ArrayList[n];
        Arrays.setAll(lists,i->new ArrayList<>());
        for (int[] edge : edges) {
            int x= edge[0];
            int y = edge[1];
            lists[x].add(y);
            lists[y].add(x);
        }
        ans = 0;
        dfs(0,-1,lists);
        return ans;
    }

    private int dfs(int node, int i, List<Integer>[] lists) {
        int v1 = 1;
        int v2 = 0;
        boolean isTrue = true;
        for (Integer value : lists[node]) {
            if(value==i){
                continue;
            }
            int temp = dfs(value,node,lists);
            if(v2==0){
                v2=temp;
            }else {
                if(temp!=v2){
                    isTrue = false;
                }
            }
            v1+=temp;
        }
        if(isTrue){
            ans++;
        }
        return v1;
    }
}
