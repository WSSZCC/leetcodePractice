package test.leetcode2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最多可以参加的会议数目
 */
public class MaxEvents {
    public int maxEvents(int[][] events) {
        int max = 0;
        for (int[] event : events) {
            max = Math.max(max, event[1]);
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] event : events) {
            List<Integer> list = map.getOrDefault(event[0], new ArrayList<>());
            list.add(event[1]);
            map.put(event[0], list);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i <= max; i++) {
            while (!queue.isEmpty() && queue.peek() < i) {
                queue.poll();
            }
            if (map.get(i) != null) {
                queue.addAll(map.get(i));
            }
            if (!queue.isEmpty()) {
                ans++;
                queue.poll();
            }
        }
        return ans;
    }

}
