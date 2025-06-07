package test.leetcode2025;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 删除星号以后字典序最小的字符串
 */
public class ClearStars {
    public String clearStars(String s) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            } else {
                queue.add(new int[]{chars[i] - 'a', i});
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] ints = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            ints[index] = queue.poll()[1];
            index++;
        }
        Arrays.sort(ints);
        for (int anInt : ints) {
            sb.append(s.charAt(anInt));
        }
        return sb.toString();

    }
}
