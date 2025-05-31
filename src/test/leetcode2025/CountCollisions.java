package test.leetcode2025;

import java.util.LinkedList;

/**
 * 统计道路上的碰撞次数
 */
public class CountCollisions {
    public int countCollisions(String directions) {
        int ans = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (char c : directions.toCharArray()) {
            if (list.isEmpty()) {
                if (c != 'L') {
                    list.addLast(c);
                }
                continue;
            }
            Character last = list.peekLast();
            if (last != c) {
                list.pollLast();
                if (last == 'S' && c == 'R') {
                    list.addLast(c);
                    continue;
                }
                if (last == 'R' && c == 'L') {
                    ans += 2;
                } else {
                    ans++;
                }
                while (!list.isEmpty()) {
                    list.pollLast();
                    ans++;
                }
                list.addLast('S');
            } else {
                if (last == 'S') {
                    list.pollLast();
                }
                list.addLast(c);
            }
        }
        return ans;
    }
}
