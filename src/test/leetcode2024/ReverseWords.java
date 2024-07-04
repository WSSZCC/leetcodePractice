package test.leetcode2024;

import java.util.Scanner;

/**
 * 151. 反转字符串中的单词
 */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        reverseWords(s);
    }

    private static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int index = s.length();
        boolean flag = false;
        boolean isFirst = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) - ' ' == 0) {
                if (flag) {
                    if (!isFirst) {
                        sb.append(" ");
                    }
                    sb.append(s, i + 1, index);
                    isFirst = false;
                }
                index = i;
                flag = false;
            } else {
                if (i == 0) {
                    if (sb.length() != 0) {
                        sb.append(" ");
                    }
                    sb.append(s, 0, index);
                }
                flag = true;
            }
        }
        return sb.toString();
    }
}
