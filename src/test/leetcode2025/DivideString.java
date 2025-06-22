package test.leetcode2025;


import java.util.Arrays;

/**
 * 将字符串拆分为若干长度为 k 的组
 */
public class DivideString {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] strings = new String[n / k + (n % k == 0 ? 0 : 1)];
        int index = 0;
        for (int i = 0; i < n; i+=k) {
            int value = i + k;
            if(value>n){
                String substring = s.substring(i, n);
                StringBuilder sb = new StringBuilder(substring);
                for (int j = 0; j < k - substring.length(); j++) {
                    sb.append(fill);
                }
                strings[index] = sb.toString();

            }else {
                strings[index] = s.substring(i,value);
            }
            index++;
        }
        return strings;
    }
}
