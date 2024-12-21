package test.leetcode2024;

/**
 * 根据第 K 场考试的分数排序
 */
public class SortTheStudents {
    public int[][] sortTheStudents(int[][] score, int k) {
        int n = score.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(score[j][k]<score[j+1][k]){
                    int[] ints = score[j];
                    score[j] = score[j+1];
                    score[j+1] = ints;
                }
            }
        }
        return score;
    }
}
