package test.leetcode2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 最近的房间
 */
public class ClosestRoom {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int m = queries.length;
        int[][] ints = new int[m][3];
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            ints[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(ints, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[][] ints1 = genIntsByRooms(rooms);
        Arrays.sort(ints1, Comparator.comparingInt(a -> a[0]));
        for (int[] ints2 : ints) {
            boolean isChange = false;
            for (int[] value : ints1) {
                if(ints2[0] >= value[0]){
                    if(ints2[1] <= value[1]){
                        ans[ints2[2]] = value[0];
                        isChange = true;
                    }
                }else {
                    if(isChange&&(Math.abs(ans[ints2[2]]-ints2[0])<=Math.abs(value[0]-ints2[0]))){
                        break;
                    }
                    if(ints2[1] <= value[1]){
                        ans[ints2[2]] = value[0];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private int[][] genIntsByRooms(int[][] rooms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] room : rooms) {
            Integer orDefault = map.getOrDefault(room[0], 0);
            if (orDefault < room[1]) {
                map.put(room[0], room[1]);
            }
        }
        int[][] ints = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            ints[index] = new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()};
        }
        return ints;
    }
}
