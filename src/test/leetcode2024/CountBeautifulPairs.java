package test.leetcode2024;

import java.util.*;

/**
 * 美丽下标对的数目
 */
public class CountBeautifulPairs {
    public static void main(String[] args) {
        countBeautifulPairs(new int[]{31,25,72,79,74});
    }

    public static int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        List<Integer> firstNumberList = new ArrayList<>();
        List<Integer> lastNumberList = new ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            firstNumberList.add(Integer.parseInt(String.valueOf(s.charAt(0))));
            lastNumberList.add(Integer.parseInt(String.valueOf(s.charAt(s.length() - 1))));
        }
        List<Integer> primeList = Arrays.asList(1, 5, 7);
        for (int i = 0; i < firstNumberList.size() - 1; i++) {
            Set<Integer> set = new HashSet<>();
            if (!primeList.contains(firstNumberList.get(i))) {
                for (int j = 2; j < 5; j++) {
                    if (firstNumberList.get(i) == j) {
                        set.add(j);
                        break;
                    }
                    if (firstNumberList.get(i) % j == 0) {
                        set.add(firstNumberList.get(i) / j);
                    }
                }
            }
            for (int j = i + 1; j < lastNumberList.size(); j++) {
                if(firstNumberList.get(i)!=1&&firstNumberList.get(i)==lastNumberList.get(j)){
                    continue;
                }
                count++;
                if (!set.isEmpty()) {
                    for (Integer value : set) {
                        if(lastNumberList.get(j)%value==0){
                            count--;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
