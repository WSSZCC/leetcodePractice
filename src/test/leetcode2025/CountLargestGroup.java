package test.leetcode2025;

import java.util.Arrays;

/**
 * 统计最大组的数目
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int[] ints = new int[37];
        for (int i = 1; i <= n; i++) {
            int ans  = 0;
            int flag = i;
            while (flag>0){
                ans+=flag%10;
                flag/=10;
            }
            ints[ans]++;
        }
        Arrays.sort(ints);
        int count = 1;
        for (int i = 35; i >=0; i--) {
            if(ints[i]!=ints[i+1]){
                break;
            }
            count++;
        }
        return count;
    }
}
