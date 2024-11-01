package test.leetcode2024;

import java.util.Arrays;

/**
 * 总持续时间可被 60 整除的歌曲
 */
public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        numPairsDivisibleBy60(new int[]{30,20,150,100,40});
    }
    public static int numPairsDivisibleBy60(int[] time) {
        int[] ints = new int[60];
        Arrays.fill(ints,0);
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int value = time[i] % 60;
            count+=ints[(60-value)%60];
            ints[value]++;
        }
        return count;
    }
}
