package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 清除数字
 */
public class ClearDigits {
    public String clearDigits(String s) {
        int n = s.length();
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c -'0'>=0&&c-'0'<=9){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else {
                queue.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
