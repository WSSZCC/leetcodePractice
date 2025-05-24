package test.leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找包含给定字符的单词
 */
public class FindWordsContaining {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int index =0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if(x==word.charAt(i)){
                    list.add(index);
                    break;
                }
            }
            index++;
        }
        return list;
    }
}
