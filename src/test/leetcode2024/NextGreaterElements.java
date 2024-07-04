package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 下一个更大元素 II
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        nextGreaterElements(new int[]{100,1,11,1,120,111,123,1,-1,-100});
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!list.isEmpty()&&nums[list.peekLast()]<num){
                Integer index = list.pollLast();
                ans[index] = num;
            }
            list.add(i);
        }
        int flag = n;
        if(!list.isEmpty()){
            flag = list.pop();
            ans[flag] = -1;
            flag++;
        }
        while (!list.isEmpty()){
            Integer integer = list.pop();
            int value = -1;
            for (int i = 0; i <= flag; i++) {
                if(nums[i]>nums[integer]){
                    value = nums[i];
                    break;
                }
            }
            ans[integer] = value;
        }
        return ans;
    }
}
