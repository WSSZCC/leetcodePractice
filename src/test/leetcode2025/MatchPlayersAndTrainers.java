package test.leetcode2025;

import java.util.Arrays;

/**
 * 运动员和训练师的最大匹配数
 */
public class MatchPlayersAndTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        while (n>0&&m>0){
            if(players[n-1]<=trainers[m-1]){
                ans++;
                m--;
            }
            n--;
        }
        return ans;
    }
}
