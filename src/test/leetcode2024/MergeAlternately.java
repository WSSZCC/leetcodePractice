package test.leetcode2024;

import java.util.Scanner;

/**
 * 1768. 交替合并字符串
 */
public class MergeAlternately {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        System.out.println(mergeAlternately(s, s1));
    }

    private static String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int minLength = Math.min(chars1.length, chars2.length);
        char[] res = new char[2 * minLength];
        for (int i = 0; i < minLength; i++) {
            res[2 * i] = chars1[i];
            res[2 * i + 1] = chars2[i];
        }
        String s = new String(res);
        if (minLength < chars1.length) {
            s = s + word1.substring(minLength, chars1.length);
        }
        if (minLength < chars2.length) {
            s = s + word2.substring(minLength, chars2.length);
        }
        return s;
    }
}
