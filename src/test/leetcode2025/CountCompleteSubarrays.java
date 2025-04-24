package test.leetcode2025;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 统计完全子数组的数目
 */
public class CountCompleteSubarrays {
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{381,1304,381,758,1304,381,758}));
    }
    public static int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            set.add(num);
        }
        int flag = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            map.put(nums[i], orDefault + 1);
            set.remove(nums[i]);
            if (set.isEmpty()) {
                ans += n - i;
                while (true) {
                    Integer integer = map.get(nums[flag]);
                    if (integer == 1) {
                        map.put(nums[flag], 0);
                        set.add(nums[flag]);
                        flag++;
                        break;
                    }
                    map.put(nums[flag], integer - 1);
                    ans += n - i;
                    flag++;
                }
            }
        }
        return ans;
    }
}
