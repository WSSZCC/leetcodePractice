package test.leetcode2024;

/**
 * 判断是否可以赢得数字游戏
 */
public class CanAliceWin {
    public boolean canAliceWin(int[] nums) {
        int v1 = 0;
        for (int num : nums) {
           v1 += num>9?-num:num;
        }
        return v1!=0;
    }
}
