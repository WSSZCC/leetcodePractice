package test.leetcode2025;

import java.util.LinkedList;
import java.util.Objects;

public class CountSubarrays {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913},
                35054,945315));
    }
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int flag = 0;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || maxK < nums[i]) {
                ans = getAns(ans, flag, list, list1, i);
                list = new LinkedList<>();
                list1 = new LinkedList<>();
                flag = i + 1;
                continue;
            }
            if (nums[i] == minK) {
                list.addFirst(i);
            }
            if (nums[i] == maxK) {
                list1.addFirst(i);
            }
            if(i==n-1){
                ans = getAns(ans, flag, list, list1, n);
            }
        }
        return ans;
    }

    private static long getAns(long ans, int flag, LinkedList<Integer> list, LinkedList<Integer> list1, int i) {
        while (!list.isEmpty() && !list1.isEmpty()) {
            int v1 = 0;
            int v2 = 0;
            if(list.peekLast()> list1.peekLast()){
                v1 = list1.pollLast();
                v2 = list.peekLast();
            }else if (Objects.equals(list.peekLast(), list1.peekLast())){
                v1 = list1.pollLast();
                v2 = list.pollLast();
            }else {
                v1 = list.pollLast();
                v2 = list1.peekLast();
            }
            ans += (long) (v1 - flag + 1) *(i -v2);
            flag=v1+1;
        }
        return ans;
    }
}
