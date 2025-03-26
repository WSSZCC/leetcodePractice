package test.leetcode2025;

import java.util.HashSet;

/**
 * k-avoiding 数组的最小总和
 */
public class MinimumSum {
    public int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= k/2; i++) {
            int value = k-i;
            if(value>i){
            set.add(value);
            }
        }
        int ans = 0;
        int flag =1;
        while (n>0){
            if(!set.contains(flag)) {
                ans += flag;
                n--;
            }
            flag++;
        }
        return ans;
    }
}
