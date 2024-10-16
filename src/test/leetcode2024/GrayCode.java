package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 89. 格雷编码
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        Integer[] ints = new Integer[1 << n];
        ints[0] = 0;
        ints[1] = 1;
        int flag = 2;
        int index = 2;
        while (flag<=n){
            int v1 = 1 << flag;
            ints[v1-1] = 1<<flag-1;
            int value = ints[v1-1] - ints[0];
            for (int i = 1; i < index; i++) {
                ints[v1-1-i] = ints[i]+value;
            }
            index = v1;
            flag++;
        }
        return Arrays.asList(ints);
    }
}
