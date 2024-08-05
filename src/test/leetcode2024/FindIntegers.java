package test.leetcode2024;

import javax.sound.midi.Soundbank;

/**
 * 不含连续1的非负整数
 */
public class FindIntegers {
    public static void main(String[] args) {
        System.out.println(1 << 29);
        System.out.println(Integer.toBinaryString(1 << 29));
        System.out.println(Integer.toBinaryString(99351714));
//        System.out.println(findIntegers(99351714));
    }

    //     TODO
    public static int findIntegers(int n) {
        int count = 0;
        if (n < 8) {
            for (int i = 0; i <= n; i++) {
                int value = i;
                boolean isSerialOne = false;
                while (value > 0) {
                    if ((value & 1) == 1) {
                        if (isSerialOne) {
                            count--;
                            break;
                        }
                        isSerialOne = true;
                    } else {
                        isSerialOne = false;
                    }
                    value >>= 1;
                }
                count++;
            }
            return count;
        }
        count = 2 + 1 + 2;
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int a = 1;
        int b = 2;
        for (int i = 3; i < len; i++) {
            int temp = a + b;
            a = b;
            b = temp;
            count += b;
        }
        int c = 1 << len;
        for (int i = n+1; i < c; i++) {
            int value = i;
            boolean isSerialOne = false;
            while (value > 0) {
                if ((value & 1) == 1) {
                    if (isSerialOne) {
                        count++;
                        break;
                    }
                    isSerialOne = true;
                } else {
                    isSerialOne = false;
                }
                value >>= 1;
            }
            count--;
        }
        return count;
    }
}

