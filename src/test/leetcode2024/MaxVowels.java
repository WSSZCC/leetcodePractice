package test.leetcode2024;

/**
 * 定长子串中元音的最大数目
 */
public class MaxVowels {
    public static void main(String[] args) {

    }

    private static int maxVowels(String s, int k) {
        int n = s.length();
        int maxValue = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                maxValue++;
            }
        }
        int temp = maxValue;
        for (int i = k; i < n; i++) {
            if(maxValue==k){
                break;
            }
            if (isVowel(s.charAt(i))) {
                temp++;
            }
            if (isVowel(s.charAt(i - k))) {
                temp--;
            }
            maxValue = Math.max(maxValue, temp);

        }
        return maxValue;
    }

    public static boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}
