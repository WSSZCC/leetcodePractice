package test.leetcode2024;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 通过投票对团队排名
 */
public class RankTeams {
    public static void main(String[] args) {
        String[] strings = {"WXYZ", "XYZW"};
        System.out.println(rankTeams(strings));
    }

    public static String rankTeams(String[] votes) {
        int n = votes.length;
        int m = votes[0].length();
        if (n == 1) {
            return votes[0];
        }
        StringBuilder[] builders = new StringBuilder[26];
        Arrays.setAll(builders, i -> new StringBuilder());
        for (int i = 0; i < m; i++) {
            int[] ints = new int[26];
            for (String vote : votes) {
                ints[vote.charAt(i) - 'A']++;
            }
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] < 1000) {
                    builders[j].append(0);
                }
                if (ints[j] < 100) {
                    builders[j].append(0);
                }
                if (ints[j] < 10) {
                    builders[j].append(0);
                }
                builders[j].append(ints[j]);
            }
        }
        PriorityQueue<String[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1[1], o2[1])) {
                return o1[0].compareTo(o2[0]);
            }
            return o2[1].compareTo(o1[1]);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append("0000");
        }
        for (int i = 0; i < builders.length; i++) {
            String s = builders[i].toString();
            if (s.equals(sb.toString())) {
                continue;
            }
            queue.add(new String[]{((char) (i + 'A')) + "", s});
        }
        StringBuilder sb1 = new StringBuilder();
        while (!queue.isEmpty()) {
            sb1.append(queue.poll()[0]);
        }
        return sb1.toString();
    }
}
