package test.leetcode2024;

import java.util.LinkedList;

/**
 * 跳跃游戏 VII
 */
public class CanReachVII {
    public static void main(String[] args) {
        canReach("01000110110", 2, 3);
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        StringBuilder sb = new StringBuilder(s);
        int left = minJump;
        while (!queue.isEmpty()) {
            Integer poll = queue.peek();
            if (poll + minJump >= n) {
                return false;
            }
            if (poll + maxJump >= n - 1) {
                return true;
            }
            queue.poll();
            for (int i = Math.max(left, poll + minJump); i <= poll + maxJump; i++) {
                if (sb.charAt(i) == '0') {
                    if (i == n - 1) {
                        return true;
                    }
                    queue.add(i);
                    sb.setCharAt(i, '1');
                }
            }
            left = poll + maxJump;
        }
        return false;
    }
}
