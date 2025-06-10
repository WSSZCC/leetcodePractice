package test.leetcode2025;

/**
 * 奇偶频次间的最大差值 I
 */
public class MaxDifference {
    public int maxDifference(String s) {
        int[] ints = new int[26];
        for (char c : s.toCharArray()) {
            ints[c-'a']++;
        }
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int anInt : ints) {
            if(anInt==0){
                continue;
            }
            if(anInt%2==0){
                min1 = Math.min(min1,anInt);
            }else {
                max2 = Math.max(max2,anInt);
            }
        }
        return max2-min1;
    }
}
