package test.leetcode2024;

import java.util.HashSet;

/**
 * 生成特殊数字的最少操作
 */
public class MinimumOperations {
    public static void main(String[] args) {
        System.out.println(minimumOperations("0"));
    }

    public static int minimumOperations(String num) {
        HashSet<String> set = new HashSet<>();
        set.add("00");
        set.add("75");
        set.add("25");
        set.add("50");
        int n = num.length();
        int isZeroCount = 0;
        if(n==1){
            return num.equals("0") ?0:1;
        }
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                isZeroCount++;
            }
        }
        int count = 0;
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' || c == '5') {
                index = i;
                break;
            }
            count++;
        }
        if (index == 0) {
            return n;
        }
        int ansCount = 0;
        boolean isChange = false;
        for (int i = index; i >= 1; i--) {
            int curCount = count;
            for (int j = i - 1; j >= 0; j--) {
                String s = new String(new char[]{num.charAt(j), num.charAt(i)});
                if(set.contains(s)){
                    isChange = true;
                    ansCount = ansCount==0?curCount:Math.min(ansCount,curCount);
                    break;
                }
                curCount++;
            }
            count++;
            if(isChange&&count>=ansCount){
                break;
            }
        }

        return isChange?ansCount:n-isZeroCount;
    }
}
