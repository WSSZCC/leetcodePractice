package test.leetcode2024;

/**
 * 公交站间的距离
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int sum1 = 0;
        int sum2 = 0;
        if (start < destination) {
            for (int i = 0; i < n; i++) {
                if (i >= start && i < destination) {
                    sum1 += distance[i];
                } else {
                    sum2 += distance[i];
                }
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (i < start && i >= destination) {
                    sum1 += distance[i];
                } else {
                    sum2 += distance[i];
                }
            }
        }
        return Math.min(sum1,sum2);
    }
}
