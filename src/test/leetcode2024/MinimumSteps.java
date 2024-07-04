package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 区分黑球与白球
 */
public class MinimumSteps {
    public static void main(String[] args) {
        minimumSteps("100");
    }

    public static long minimumSteps(String s) {
        Deque<Integer> queue = new LinkedList<>();
        int n = s.length();
        long result = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(s.charAt(i)=='0'){
                queue.add(i);
            }else {
                if(!queue.isEmpty()){
                    result += queue.pop()-i;
                    queue.add(i);
                }
            }
        }
        return result;
    }
}
