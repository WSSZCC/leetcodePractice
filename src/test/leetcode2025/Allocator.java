package test.leetcode2025;

import java.util.Arrays;

/**
 * 设计内存分配器
 */
public class Allocator {
    int[] ints;

    public Allocator(int n) {
        ints = new int[n];
        Arrays.fill(ints, 0);
    }

    public int allocate(int size, int mID) {
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                ans = 0;
            } else {
                ans++;
            }
            if (ans == size) {
                while (ans > 0) {
                    ints[i - ans] = mID;
                    ans--;
                }
                return i - size;
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == mID) {
                ints[i] = 0;
                ans++;
            }
        }
        return ans;
    }
}
