package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 计算 K 置位下标对应元素的和
 */
public class SumIndicesWithKSetBits {

    public static void main(String[] args) {
        sumIndicesWithKSetBits(Arrays.asList(4,3,2,1),2);
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        if(k==0){
            return nums.get(0);
        }
        for (int i = 0; i < nums.size(); i++) {
            String s = Integer.toBinaryString(i);
            int flag = k;
            for (char c : s.toCharArray()) {
                if(c=='1'){
                    flag--;
                }
            }
            if(flag==0){
                sum+=nums.get(i);
            }

        }
        return sum;
    }
}
