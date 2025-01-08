package test.leetcode2024;

/**
 * 字符串中最大的 3 位相同数字
 */
public class LargestGoodInteger {
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        char c = ' ';
        for (int i = 2; i < chars.length; i++) {
            if (chars[i - 2] == chars[i - 1] && chars[i - 1] == chars[i] && chars[i] > c) {
                c = chars[i];
            }
        }
        return c==' '?"":c + "" + c + "" + c;
    }
}
