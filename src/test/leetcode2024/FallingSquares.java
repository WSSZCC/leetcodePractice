package test.leetcode2024;

import java.util.*;

/**
 * 掉落的方块
 */
public class FallingSquares {
    public static void main(String[] args) {
        String s = "[18,39],[66,31],[34,1],[90,17],[31,47],[12,30],[15,9],[63,37],[83,41],[85,78],";
        String[] split = s.split("],");
        int[][] ints = new int[split.length][2];
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].replace('[', ' ').split(",");
            ints[i] = new int[]{Integer.parseInt(split1[0].trim()),Integer.parseInt(split1[1].trim())};
        }
        fallingSquares(ints);
    }

    public static List<Integer> fallingSquares(int[][] positions) {
        List<Integer> list = new ArrayList<>();
        List<int[]> segmentList = new ArrayList<>();
        int height = 0;
        for (int[] position : positions) {
            int right = position[0] + position[1];
            List<int[]> currentSegmentList = new ArrayList<>();
            boolean isChange = false;
            int currentHeight = 0;
            for (int[] ints : segmentList) {
                if (ints[0] >= right || ints[1] <= position[0]) {
                    currentSegmentList.add(ints);
                } else {
                    currentHeight = Math.max(currentHeight, ints[2] + position[1]);
                    isChange = true;
                }
            }
            if (isChange) {
                currentSegmentList.add(new int[]{position[0], right, currentHeight});
                for (int[] ints : segmentList) {
                    if (ints[0] < right || ints[1] > position[0]) {
                        if (position[0] > ints[0]&&position[0]<ints[1]) {
                            currentSegmentList.add(new int[]{ints[0], position[0], ints[2]});
                        }
                        if (right < ints[1]&&right>ints[0]) {
                            currentSegmentList.add(new int[]{right, ints[1], ints[2]});
                        }
                    }
                }
                height = Math.max(currentHeight,height);
                segmentList = currentSegmentList;
            } else {
                height = Math.max(height, position[1]);
                segmentList.add(new int[]{position[0], right, position[1]});
            }
            list.add(height);
            segmentList.sort(Comparator.comparingInt(a -> a[0]));
        }
        return list;
    }
}
