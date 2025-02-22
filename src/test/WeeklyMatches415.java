package test;

import java.util.HashSet;

public class WeeklyMatches415 {
    public static void main(String[] args) {
        maxScore(new int[]{-1,4,5,-2},new int[]{-5,-1,-3,-2,-4});
    }
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int[] ints = new int[2];
        int index = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ints[index] = num;
                index++;
            }
            set.add(num);
            if (index == 2) {
                break;
            }
        }
        return  ints;
    }

    public static long maxScore(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        long[][] ints = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m-3+i; j++) {
                ints[i][j] = (long) a[i] *b[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m-3+i; j++) {
                if(j+1<m-3+i){
                    ints[i][j+1] = Math.max(ints[i][j],ints[i][j+1]);
                }
                if(j+1<=m-3+i&&i+1<4){
                    ints[i+1][j+1] +=ints[i][j];
                }
            }
        }
        return ints[n-1][m-1];
    }
}
