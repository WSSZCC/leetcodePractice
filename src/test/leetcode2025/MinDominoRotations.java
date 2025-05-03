package test.leetcode2025;

/**
 * 行相等的最少多米诺旋转
 */
public class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        boolean isTrue = true;
        boolean isTrue1 = true;
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            if(isTrue){
                if(tops[0]!=tops[i]&&tops[0]!=bottoms[i]) {
                    System.out.println(tops[i]);
                    ans1 =Integer.MAX_VALUE;
                    isTrue = false;
                }
                if(tops[0]!=tops[i]&&tops[0]==bottoms[i]){
                    ans1++;
                }
            }
            if(isTrue1){
                if(bottoms[0]!=bottoms[i]&&bottoms[0]!=tops[i]) {
                    ans2 =Integer.MAX_VALUE;
                    isTrue1 = false;
                }
                if(bottoms[0]!=bottoms[i]&&bottoms[0]==tops[i]){
                    ans1++;
                }
            }
        }
        ans1 = Math.min(ans1,ans2);
        return ans1==Integer.MAX_VALUE?-1:ans1;
    }
    /**
     * 暴力写法
     * @param tops
     * @param bottoms
     * @return
     */
    public int minDominoRotations1(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int flag = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (tops[j] != i && bottoms[j] != i) {
                    break;
                }
                if(tops[j] != i && bottoms[j] == i) {
                    count++;
                }
                flag++;
            }
            if (flag == n) {
                ans = Math.min(ans,count);
            }
        }
        for (int i = 1; i <= 6; i++) {
            int flag = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (tops[j] != i && bottoms[j] != i) {
                    break;
                }
                if(tops[j] == i && bottoms[j] != i) {
                    count++;
                }
                flag++;
            }
            if (flag == n) {
                ans = Math.min(ans,count);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
