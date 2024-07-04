package test.leetcode2024;

/**
 * 气温变化趋势
 */
public class TemperatureTrend {
    public static void main(String[] args) {

    }

    /**
     * @param temperatureA
     * @param temperatureB
     * @return
     */
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int maxDays = 0;
        int totalDays = 0;
        for (int i = 1; i < n; i++) {
            if (getVariationTrend(temperatureA[i - 1], temperatureA[i]) != getVariationTrend(temperatureB[i - 1], temperatureB[i])) {
                maxDays = Math.max(totalDays, maxDays);
                totalDays = 0;
            } else {
                totalDays++;
            }
        }
        return maxDays;
    }

    /**
     * 1 上升
     * 0 平稳
     * -1 下降
     *
     * @return
     */
    public int getVariationTrend(int a, int b) {
        if (a == b) {
            return 0;
        }
        return a > b ? -1 : 1;
    }
}
