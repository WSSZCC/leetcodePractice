package test.leetcode2024;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 考场就座
 */
public class ExamRoom {
    Set<Integer> set;
    int N;

    public ExamRoom(int n) {
        N = n;
        set = new TreeSet<>();
    }

    public int seat() {
        int size = set.size();
        if (size == 0) {
            set.add(0);
            return 0;
        }
        if (size == N) {
            return 0;
        }
        if (size == 1 && set.contains(0)) {
            set.add(N - 1);
            return N - 1;
        }
        int flag = -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        for (Integer value : set) {
            int len = value - flag;
            if (len <= 1) {
                flag = value;
                continue;
            }
            if (flag == -1) {
                queue.add(new int[]{len - 1, 0});
            } else {
                queue.add(new int[]{len / 2, flag + len / 2});
            }
            flag = value;
        }
        if (flag < N - 1) {
            queue.add(new int[]{N - 1 - flag, N - 1});
        }
        int[] poll = queue.poll();
        set.add(poll[1]);
        return poll[1];
    }

    public void leave(int p) {
        set.remove(p);

    }
}
