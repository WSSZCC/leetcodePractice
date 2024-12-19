package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到稳定山的下标
 */
public class StableMountains {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if(height[i-1]>threshold){
                list.add(i);
            }
        }
        return list;
    }
}
