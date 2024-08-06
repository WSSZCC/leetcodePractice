package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数相除
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(1 << 31 & 1);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean isSame = true;
        int count = 0;
        if (dividend > 0) {
            dividend = -dividend;
            isSame = !isSame;
        }
        if (divisor > 0) {
            divisor = -divisor;
            isSame = !isSame;
        }
        List<Integer> list = new ArrayList<>();
        list.add(divisor);
        int index = 0;
        //获取最接近dividend的（divisor*2^n）
        while (list.get(index) >= dividend - list.get(index)) {
            list.add(list.get(index) + list.get(index));
            index++;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            // 如果判断为true就代表dividend还可以被（divisor*2^n）相减
            if (list.get(i) >= dividend) {
                count += 1 << i;
                dividend -= list.get(i);
            }
        }
        return isSame ? count : -count;
    }
}
