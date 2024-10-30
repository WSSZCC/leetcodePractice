package test.leetcode2024;

/**
 * 满足距离约束且字典序最小的字符串
 */
public class GetSmallestString {
    public static void main(String[] args) {
        System.out.println(getSmallestString("zbbz", 3));
    }


    public static String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (k > 0) {
                int minDistance = Math.min(c - 'a', 'a' - c + 26);
                if (k - minDistance < 0) {
                    c = (char) (c - k);
                    k = 0;
                } else {
                    k -= minDistance;
                    c = 'a';
                }
            }
            chars[i] = c;
        }
        return new String(chars);
    }
}
