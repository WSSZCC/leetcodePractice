package test.leetcode2024;

/**
 * 得到更多分数的最少关卡数目
 */
public class MinimumLevels {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int target = 0;
        for (int j : possible) {
            if (j == 1) {
                target++;
            } else {
                target--;
            }
        }
        int score = 0;
        for (int i = 0; i < n-1; i++) {
            if(possible[i]==1){
                score++;
                target--;
            }else {
                score--;
                target++;
            }
            if(score>target){
                return i+1;
            }
        }
        return -1;
    }
}
