package test.leetcode2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 转换二维数组
 */
public class FindMatrix {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int pre = -1;
        int flag = 0;
        for (int num : nums) {
            if (num != pre) {
                flag = 0;
                list.get(flag).add(num);
                pre = num;
            } else {
                if(list.size()-1<flag){
                    list.add(new ArrayList<>());
                }
                flag++;
                list.get(flag).add(num);
            }
        }
        return list;
    }
}
