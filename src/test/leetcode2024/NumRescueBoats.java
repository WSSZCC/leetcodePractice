package test.leetcode2024;

import java.util.Arrays;

/**
 * 救生艇
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        numRescueBoats(new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10}, 50);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int sum = 0;
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            int temp = people[r];
            if(temp+people[l]<=limit){
                l++;
            }
            sum++;
            r--;
        }
        return sum;
    }

//    public static void backtrack(int limit)
}
