package test.leetcode2024;

import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.Set;

/**
 * 解码方法
 */
public class NumDecodings {

    public static void main(String[] args) {
        System.out.println(numDecodings("1201234"));
    }

    private static int n;


    public static int numDecodings(String s) {
        if ('0' == s.charAt(0) || s.contains("00")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        int[] ints = new int[len + 1];
        ints[0] = 1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i) != '0'){
                ints[i]+=ints[i-1];
            }
            if(i-2>=0&& !(s.charAt(i-2) >= '3'||s.charAt(i-2)=='0' || (s.charAt(i-2) == '2' && s.charAt(i -1) > '6'))){
                ints[i] +=ints[i-2];
            }
        }
        return ints[len];
    }


    /**
     * @param s
     * @return  dfs会超时
     */
    public static int numDecodings1(String s) {
        if ('0' == s.charAt(0) || s.contains("00")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        n = 0;
        backtrack(0, s.length(), s);
        return n;
    }

    private static void backtrack(int index, int len, String s) {
        if (index >= len) {
            if (index == len) {
                n++;
            }
            return;
        }
        if (index + 1 < len && !(s.charAt(index) >= '3'||s.charAt(index)=='0' || (s.charAt(index) == '2' && s.charAt(index + 1) > '6'))) {
            System.out.println("two" + index);
            backtrack(index + 2, len, s);
        }
        if (s.charAt(index) != '0') {
            System.out.println("one" + index);
            backtrack(index + 1, len, s);
        }
    }
}
