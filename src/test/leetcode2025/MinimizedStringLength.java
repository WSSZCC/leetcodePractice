package test.leetcode2025;

import java.util.HashSet;

/**
 * 最小化字符串长度
 */
public class MinimizedStringLength {
    public int minimizedStringLength(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
