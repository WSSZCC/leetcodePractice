package test.leetcode2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 3133. 数组最后一个元素的最小值
 */
public class MinEnd {
    public static void main(String[] args) {
        minEnd(3,4);
    }
    public static long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }
        if(x==1){
            return  (2L *(n-1))+1;
        }
        String s = Integer.toBinaryString(x);
        int m = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
           if(s.charAt(i)=='1'){
               set.add((long) (m-1-i));
           }
        }
        long count = getCountByX(x);
        long flag = 0;
        while ((1<<(count+flag))<n){
            flag++;
        }
        long value = count+flag;
        StringBuilder sb = new StringBuilder();
        for (long i = flag + m-1;i>=0; i--) {
            if(set.contains(i)){
                sb.append('1');
            }else {
                if(n>1&&n-(1<<(value-1))>=1){
                    n -=(1<<value-1);
                    sb.append('1');
                }else {
                    sb.append('0');
                }
                value--;
            }
        }
        String s1 = sb.toString();
        long l = Long.parseLong(s1, 2);
        return l;
    }

    private static long getCountByX(int x) {
        long count = 0;
        int value = x;
        while (value > 1) {
            if ((value & 1) == 0) {
                count++;
            }
            value >>= 1;
        }
        return count;
    }
}
