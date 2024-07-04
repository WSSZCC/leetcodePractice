package test.leetcode2024;

import java.util.Scanner;

public class Compress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        compress1(s.toCharArray());
    }

    /**
     * @param chars
     * @return 不合题意的做法
     */
    public static int compress1(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        int first = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || chars[i] != chars[i + 1]) {
                int count = i - first + 1;
                sb.append(chars[i]);
                if (count > 1) {
                    sb.append(count);
                }
                first = i + 1;
            }
        }
        String s = new String(sb);
        int index = 0;
        for (char c : s.toCharArray()) {
            chars[index++] = c;
        }

        return s.length();
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
