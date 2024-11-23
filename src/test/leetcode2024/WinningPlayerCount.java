package test.leetcode2024;

/**
 * 求出胜利玩家的数目
 */
public class WinningPlayerCount {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] ints = new int[11][n];
        for (int[] ints1 : pick) {
            ints[ints1[1]][ints1[0]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                if (ints[j][i] > i) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
