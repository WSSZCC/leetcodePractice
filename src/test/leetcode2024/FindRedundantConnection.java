package test.leetcode2024;

/**
 * 冗余连接
 */
public class FindRedundantConnection {
    private int[] parent;

    public void findRedundantConnection(int n) {
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int x){

        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x,int y){
        parent[find(x)] = find(y);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        findRedundantConnection(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (find(x)==find(y)) {
                return edge;
            }
            union(x,y);

        }
        return new int[2];
    }
}

