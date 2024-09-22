package test.leetcode2024;

/**
 * 找到小镇的法官
 */
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] ints = new int[n+1];
        int[] ints1 = new int[n+1];
        for (int[] ints2 : trust) {
            ints[ints2[0]]++;
            ints1[ints2[1]]++;
        }
        int index = -1;
        for (int i = 1; i <= n; i++) {
            if(ints[i]==0&&ints1[i]==n-1){
                index = i;
                break;
            }
        }
        return index;
    }
}
