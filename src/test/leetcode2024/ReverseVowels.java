package test.leetcode2024;

/**
 * 反转字符串中的元音字母
 */
public class ReverseVowels {
    public static void main(String[] args) {
        reverseVowels("LEETCODE");
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(chars[i])) {
                i++;
            }
            while (j > 0 && !isVowel(chars[j])) {
                j--;
            }
            if (i < j) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static boolean isVowel(char a) {
        return a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'i' || a == 'I' || a == 'o' || a == 'O' || a == 'u' || a == 'U';
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
