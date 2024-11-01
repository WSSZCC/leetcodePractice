package test.leetcode2024;

/**
 * 超级饮料的最大强化能量
 */
public class MaxEnergyBoost {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] intsA = new long[n];
        long[] intsB = new long[n];
        intsA[0] = energyDrinkA[0];
        intsB[0] = energyDrinkB[0];
        intsA[1] = Math.max(intsA[0]+energyDrinkA[1],intsB[0]);
        intsB[1] = Math.max(intsA[0],intsB[0]+energyDrinkB[1]);
        for (int i = 2; i < n; i++) {
            intsA[i] =Math.max(intsA[i-1],intsB[i-2])+energyDrinkA[i];
            intsB[i] =Math.max(intsB[i-1],intsA[i-2])+energyDrinkB[i];
        }
        return Math.max(intsA[n-1],intsB[n-1]);
    }
}
