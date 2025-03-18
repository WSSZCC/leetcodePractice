package test.leetcode2025;

import java.util.LinkedList;

/**
 * 使字符串平衡的最小交换次数
 */
public class MinSwaps {
    public int minSwaps(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c==']'&&!list.isEmpty()&&list.peekLast()=='['){
                list.pollLast();
                continue;
            }
            list.addLast(c);
        }
        return list.size()/4+list.size()/2%2;
    }
}
