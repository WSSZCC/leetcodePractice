package test.leetcode2024;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按分隔符拆分字符串
 */
public class SplitWordsBySeparator {
    public static void main(String[] args) {
        System.out.println("aacc".substring(0,0));
        splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.');

    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int firstIndex = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (i  > firstIndex) {
                        list.add(word.substring(firstIndex, i));
                    }
                    firstIndex = i + 1;
                }
            }
            if(firstIndex<word.length()){
                list.add(word.substring(firstIndex));
            }
        }
        return list;
    }
}
