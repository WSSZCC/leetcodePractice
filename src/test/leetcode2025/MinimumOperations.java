package test.leetcode2025;

/**
 * 使数组元素互不相同所需的最少操作次数
 */
public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] ints = new int[101];
        for (int num : nums) {
           ints[num]++;
        }
        int times = 0;
        check(ints);
        for (int i = 0; i < n; i+=3) {
            if(check(ints)){
                break;
            }
            for (int j = i; j < Math.min(n,i+3); j++) {
                ints[nums[j]]--;
            }
            times++;
        }
        return times;
    }

    private boolean check(int[] ints) {
        for (int anInt : ints) {
            if(anInt>1){
                return false;
            }
        }
        return true;
    }
}
