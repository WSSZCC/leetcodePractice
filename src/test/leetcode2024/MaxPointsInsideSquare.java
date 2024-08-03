package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 正方形中的最多点数
 */
public class MaxPointsInsideSquare {
    public static void main(String[] args) {
        maxPointsInsideSquare(new int[][]{{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}},"cbdcc");
    }
    public static int maxPointsInsideSquare(int[][] points, String s) {
        int ans = 0;
        int lenIndex = 0;
        int n = points.length;
        Set<Integer> lenSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            lenSet.add(Math.abs(point[0]));
            lenSet.add(Math.abs(point[1]));
        }
        List<Integer> lenList = lenSet.stream().sorted().collect(Collectors.toList());
        Set<Character> tagSet = new HashSet<>();
        Set<Integer> indexSet = new HashSet<>();
        while (ans<26){
            int maxY = lenList.get(lenIndex);
            int minY = -lenList.get(lenIndex);
            int maxX = lenList.get(lenIndex);
            int minX = -lenList.get(lenIndex);
            for (int i = 0; i < n; i++) {
                if(!indexSet.contains(i)){
                    int[] point = points[i];
                    if(point[0]>=minX&&point[0]<=maxX&&point[1]>=minY&&point[1]<=maxY){
                        char c = s.charAt(i);
                        if(tagSet.contains(c)){
                            return ans;
                        }
                        tagSet.add(c);
                        indexSet.add(i);
                    }
                }
            }
            lenIndex++;
            ans = tagSet.size();
            if(indexSet.size()== n){
                break;
            }
        }
        return ans;
    }

    /**
     * @param points
     * @param s
     *  维护不会重复的临界边长
     * @return
     */
    public int maxPointsInsideSquare1(int[][] points, String s) {
        int[] min1 = new int[26];
        Arrays.fill(min1, 1000000001);
        int min2 = 1000000001, n = s.length();
        for (int i = 0; i < n; ++i) {
            int x = points[i][0], y = points[i][1], j = s.charAt(i) - 'a';
            int d = Math.max(Math.abs(x), Math.abs(y));
            if (d < min1[j]) {
                min2 = Math.min(min2, min1[j]);
                min1[j] = d;
            } else if (d < min2) {
                min2 = d;
            }
        }
        int res = 0;
        for (int d : min1) {
            if (d < min2) {
                ++res;
            }
        }
        return res;
    }
}
