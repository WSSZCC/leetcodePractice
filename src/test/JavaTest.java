package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String[] s1 = s.split("\\.");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1].split("")[0]);
        if (b >= 5) {
            a++;
        }
        System.out.println(a);
//        System.out.println((1 / 8.84372) * (1 / 8.84372) * (1 / 8.84372) * (1 / 8.84372) * (1 / 8.84372));
//        System.out.println(myPow(8.84372, -5));
//        int[][] matrix = new int[][]{{1}, {3}, {5}};
//        System.out.println(reorganizeString("vvvlo"));
    }

    public boolean canJump1(int[] nums) {
        boolean isJump = false;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= flag) {
                flag = Math.max(flag, nums[i] + i);
                if (flag >= nums.length - 1) {
                    isJump = true;
                    break;
                }
            }
        }
        return isJump;
    }

    // 跳跃游戏
    //    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个下标。
//            1 <= nums.length <= 3 * 104
//            0 <= nums[i] <= 105
//
//    输入：nums = [2,3,1,1,4]
//    输出：true
//    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//    输入：nums = [3,2,1,0,4]
//    输出：false
//    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


    public boolean canJump(int[] nums) {
        int len = nums.length;
        int flag = 0;
        //当nums长度只有1时代表已经到达
        if (len == 1) {
            return true;
        }
        boolean isJump = false;
        for (int i = 0; i < len; i++) {
            if (i <= flag) {
                // 比较相邻谁可以走的更远
                flag = Math.max(flag, i + nums[i]);
                if (flag >= len - 1) {
                    isJump = true;
                    break;
                }
            } else {
                //如果i>flag代表现在永远到不了终点了,没有循环下去的必要性了
                break;
            }
        }
        return isJump;
    }

    //Pow(x, n)
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return calPow(x, n, 1);
    }

    public static double calPow(double x, int n, double res) {
        int rem = n % 2;
        n = n / 2;
        if (n == 0) {
            return res * x;
        }
        if (rem == 1) {
            res = res * x;
        }
        x = x * x;
        return calPow(x, n, res);
    }

    // 53. 最大子数组和
    public int maxSubArray(int[] nums) {
        int x = 0;//当前最好的
        int res = nums[0];//最最美好的
        for (int i = 0; i < nums.length; i++) {
            // 如果 x + nums[i]<nums[i],则x拖累了nums[i],num[i]要抛弃x,开始一段新的连续子数组；
            // 如果 x + nums[i]>nums[i],则代表还能继续下去，可能会更好，有可能已经走下坡路了
            x = Math.max(x + nums[i], nums[i]);
            res = Math.max(res, x);
        }
        return res;
    }

    //75. 颜色分类
    // 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    //
    //我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    //
    //必须在不使用库内置的 sort 函数的情况下解决这个问题。
    //
    //
    public void sortColors(int[] nums) {
        int n = nums.length;
        int flag = 0;
        //先把0全部放到前面,flag记录按顺序放置的最后一个0的下标，
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[flag];
                nums[flag] = temp;
                flag++;
            }
        }
        //从flag开始，再来放1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[flag];
                nums[flag] = temp;
                flag++;
            }
        }
    }

    // 74. 搜索二维矩阵
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int k = m - 1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == target) {
                return true;
            }
            if (matrix[i][k] > target) {
                k = Math.max(m - 1, 0);
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //    134. 加油站
//
//    在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//    给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int flag = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                flag = (i + 1) % n;
                if (flag == 0) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < flag; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                return -1;
            }
        }
        return flag;
    }

    //打家劫舍 还是抢不太明白
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = cur;
            cur = Math.max(pre + nums[i], temp);
            pre = temp;
        }
        return Math.max(pre, cur);
    }

    //767. 重构字符串
    public static String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] count = new int[26];
        // 收集每个字符出现的次数
        for (char aChar : chars) {
            count[aChar - 'a']++;
        }
        // 获取出现次数最多的字符
        int maxInt = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count[maxInt]) {
                maxInt = i;
            }
        }
        // 当字符的出现次数大于(原字符串长度+1)/2,则代表一定会出现相邻的情况
        if (count[maxInt] > (n + 1) / 2) {
            return "";
        }
        int i = 0;
        char[] target = new char[n];
        while (count[maxInt] > 0) {
            target[i] = (char) (maxInt + 'a');
            i += 2;
            count[maxInt]--;
        }
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                if (i >= n) {
                    i = 1;
                }
                target[i] = (char) (j + 'a');
                i += 2;
                count[j]--;
            }
        }
        return new String(target);
    }
}


