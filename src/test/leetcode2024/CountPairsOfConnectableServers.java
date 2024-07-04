package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在带权树网络中统计可连接服务器对数目
 */
public class CountPairsOfConnectableServers {
    public static void main(String[] args) {

    }

    /**
     * @param edges  每日一抄,会写二叉树再回来重写
     * @param signalSpeed
     * @return
     */
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] lists = new ArrayList[n];
        Arrays.setAll(lists, i -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            int c = e[2];
            lists[a].add(new int[]{b, c});
            lists[b].add(new int[]{a, c});
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (lists[i].size() == 1) {
                continue;
            }
            int sum = 0;
            for (int[] ints : lists[i]) {
                int temp = dfs(ints[0], i, ints[1], lists, signalSpeed);
                ans[i] += temp * sum;
                sum += temp;
            }
        }
        return ans;
    }

    private int dfs(int a, int i, int sum, List<int[]>[] lists, int signalSpeed) {
        int temp = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] ints : lists[a]) {
            int value = ints[0];
            if (value != i) {
                temp += dfs(value, a, sum + ints[1], lists, signalSpeed);
            }
        }
        return temp;
    }
}
