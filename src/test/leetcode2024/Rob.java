package test.leetcode2024;

/**
 * 打家劫舍
 */
public class Rob {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80));  // 返回 1
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(70));  // 返回 2
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(75));  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        System.out.println(stockSpanner.next(85));  // 返回 6
//        rob(new int[]{1,2,3,1});
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] ints = new int[n];
        ints[0] = nums[0];
        ints[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            ints[i] = Math.max(ints[i-2]+nums[i],ints[i-1]);
        }
        return ints[n-1];

    }
}
