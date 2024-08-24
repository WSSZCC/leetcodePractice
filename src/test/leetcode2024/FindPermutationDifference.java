package test.leetcode2024;

/**
 * 两个字符串的排列差
 */
public class FindPermutationDifference {
    public int findPermutationDifference(String s, String t) {
        int n = s.length();
        int[] ints = new int[26];
        for (int i = 0; i < n; i++) {
            int indexS = s.charAt(i) - 'a';
            int indexT = t.charAt(i) - 'a';
            if(ints[indexS]==0){
                ints[indexS] = i;
            }else {
                ints[indexS] -=i;
            }
            if(ints[indexT]==0){
                ints[indexT] = i;
            }else {
                ints[indexT] -=i;
            }
        }
        int count = 0;
        for (int anInt : ints) {
            count +=Math.abs(anInt);
        }
        return count;

    }
}
