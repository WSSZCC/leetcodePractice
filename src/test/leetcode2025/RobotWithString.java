package test.leetcode2025;

import java.util.LinkedList;

/**
 * 使用机器人打印字典序最小的字符串
 */
public class RobotWithString {
    public String robotWithString(String s) {
        int n = s.length();
        char[] chars = new char[n+1];
        chars[n] = 'z';
        for (int i = n-1; i >= 0; i--) {
            chars[i] = (char) Math.min(chars[i+1],s.charAt(i));
        }
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            list.addLast(s.charAt(i));
            while (!list.isEmpty()&&list.peekLast().compareTo(chars[i+1])<=0){
                sb.append(list.pollLast());
            }
        }
        return sb.toString();
    }
}
