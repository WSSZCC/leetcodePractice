package test.leetcode2025;

import java.util.ArrayList;

/**
 * 找出 3 位偶数
 */
public class FindEvenNumbers {
    public  int[] findEvenNumbers(int[] digits) {
        int[] ints = new int[10];
        for (int digit : digits) {
            ints[digit]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 100; i < 999; i++) {
            if(i%2==0&&vailValue(i,ints)){
                list.add(i);
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private  boolean vailValue(int i, int[] ints) {
        int[] ints1 = new int[10];
        while (i>0){
            ints1[i%10]++;
            i/=10;
        }
        for (int j = 0; j < ints1.length; j++) {
            if(ints[j]<ints1[j]){
                return false;
            }
        }
        return true;
    }
}
