package test.leetcode2024;

/**
 * 反转字符串 II
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if (k == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int flag = 1;
            int min = Math.min(n - i, k);
            for (int j = i; j < i + min / 2; j++) {
                char temp = chars[j];
                int index = i + min - flag;
                chars[j] = chars[index];
                chars[index] = temp;
                flag++;
            }
        }
        return new String(chars);
    }
}
