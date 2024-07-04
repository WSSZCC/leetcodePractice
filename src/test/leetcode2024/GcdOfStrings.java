package test.leetcode2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 1071. 字符串的最大公因子
 * <p>
 * 借鉴评论区大佬的思路
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println(gcd(12, 6));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        System.out.println(gcdOfStrings(s, s1));
    }

    private static String gcdOfStrings(String str1, String str2) {
        String s = str1 + str2;
        String s1 = str2 + str1;
        if (!s.equals(s1)) {
            return "";
        }
        int length = gcd(Math.max(str1.length(), str2.length()), Math.min(str1.length(), str2.length()));
        return s.substring(0, length);
    }

    private static int gcd(int number1, int number2) {
        if (number1 % number2 == 0) {
            return number2;
        }
        return gcd(number2, number1 % number2);
    }
}
