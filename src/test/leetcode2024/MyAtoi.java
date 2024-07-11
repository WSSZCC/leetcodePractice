package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串转换整数 (atoi)
 */
public class MyAtoi {
    public static void main(String[] args) {
        String substring = "-2147483647";
        myAtoi(substring);
        System.out.println('9' - '0');
    }

    public static int myAtoi(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)!=' '){
                index = i;
                break;
            }
        }
        String s1 = s.substring(index, n);
        int m = s1.length();
        if(m==0){
            return 0;
        }
        char c = s1.charAt(0);
        if (!(c == '-' || c == '+' || (c - '0' >= 0 && c - '9' <= 0))) {
            return 0;
        }
        int res = Math.max(c - '0', 0);
        for (int i = 1; i < m; i++) {
            int number = s1.charAt(i)-'0';
            if (number < 0 || number > 9) {
                break;
            }
            long temp = res * 10L +number;
            if(temp>Integer.MAX_VALUE){
                if(c == '-'){
                    return Integer.MIN_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
            res = res*10+number;
        }
        if(c=='-'){
            res = -res;
        }
        return res;

    }
}
