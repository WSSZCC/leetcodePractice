package test.leetcode2024;

/**
 * 每种字符至少取 K 个
 */
public class TakeCharacters {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if(n<k*3){
            return -1;
        }
        int[] ints = new int[3];
        for (char aChar : chars) {
            ints[aChar-'a']++;
        }
        for (int anInt : ints) {
            if(anInt<k){
                return -1;
            }
        }
        if(n==k*3){
            return n;
        }
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            int i = chars[right] - 'a';
            ints[i]--;
            while (ints[i]<k){
                ints[left]++;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return n-maxLen;
    }
}
