package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 从字符串中移除星号
 */
public class RemoveStars {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));

    }
    public static String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c=='*'){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return new String(builder);

    }
}
