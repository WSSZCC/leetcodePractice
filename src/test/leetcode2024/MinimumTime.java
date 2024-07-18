package test.leetcode2024;

import java.util.*;

/**
 * 访问消失节点的最少时间
 */
public class MinimumTime {
    public static void main(String[] args) {
        minimumTime(7, new int[][]{{6,1,10},{1,0,2},{3,0,10},{5,0,3},{2,0,10},{5,4,8},{5,4,3},{4,2,1},{2,2,7},{1,3,6}}, new int[]{15,6,12,15,9,16,11});
    }

    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            int length = edge[2];
            adj[v].add(new int[]{u,length});
            adj[u].add(new int[]{v,length});
        }
        int[] ansInts = new int[n];
        Arrays.fill(ansInts,-1);
        ansInts[0] = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.add(new int[]{0,0});
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            int t = poll[0];
            int v = poll[1];
            if(t!=ansInts[v]){
                continue;
            }
            for (int[] ints : adj[v]) {
                int u = ints[0];
                int length = ints[1];
                if(t+length<disappear[u]&&(ansInts[u]==-1||t+length<ansInts[u])){
                    priorityQueue.add(new int[]{t+length,u});
                    ansInts[u] = t+length;
                }
            }
        }
        return ansInts;
    }

    /**
     * @param n
     * @param edges
     * @param disappear
     * @return
     * 505 / 533 个通过的测试用例
     */
    public  int[] minimumTim1(int n, int[][] edges, int[] disappear) {
        int[] ints = new int[n];
        ints[0] = 0;
        for (int i = 1; i < n; i++) {
            ints[i] = -1;
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        while (!set1.isEmpty()) {
            Set<Integer> set2 = new HashSet<>();
            for (int[] edge : edges) {
                if (set1.contains(edge[0]) && set1.contains(edge[1])) {
                    if (ints[edge[0]] + edge[2] <= ints[edge[1]]) {
                        ints[edge[1]] = ints[edge[0]] + edge[2];
                    }
                    if (ints[edge[1]] + edge[2] <= ints[edge[0]]) {
                        ints[edge[0]] = ints[edge[1]] + edge[2];
                    }
                } else {
                    if (set1.contains(edge[0])&&!set.contains(edge[1])) {
                        int time = edge[2] + ints[edge[0]];
                        if(time <disappear[edge[1]]) {
                            ints[edge[1]] = ints[edge[1]]==-1? time: Math.min(ints[edge[1]],time);
                            set2.add(edge[1]);
                        }
                    }
                    if (set1.contains(edge[1])&&!set.contains(edge[0])) {
                        int time = edge[2] + ints[edge[1]];
                        if(time <disappear[edge[0]]) {
                            ints[edge[0]] = ints[edge[0]]==-1? time: Math.min(ints[edge[0]],time);
                            set2.add(edge[0]);
                        }
                    }
                }
            }
            set.addAll(set1);
            set1 = set2;
        }
        int[] ansInts = new int[n];
        for (int i = 0; i < n; i++) {
            ansInts[i] = ints[i] < disappear[i] ? ints[i] : -1;
        }
        return ansInts;
    }
}
