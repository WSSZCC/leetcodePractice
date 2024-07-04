package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class LetterCombinations {
    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return list;
        }
        backtrack(digits, n, 0, new StringBuilder(), list);
        return list;
    }

    public static void backtrack(String digits, int target, int start, StringBuilder subset, List<String> result) {
        if (start == target) {
            result.add(subset.toString());
            return;
        }
        List<String> list = getStringListByNum(digits.charAt(start));
        for (String s : list) {
            subset.append(s);
            backtrack(digits, target, ++start, subset, result);
            int length = subset.length();
            subset.deleteCharAt(length -1);
            start--;
        }
    }

    public static List<String> getStringListByNum(char c) {
        if (c == '2') {
            return new ArrayList<>(Arrays.asList("a", "b", "c"));
        }
        if (c == '3') {
            return new ArrayList<>(Arrays.asList("d", "e", "f"));
        }
        if (c == '4') {
            return new ArrayList<>(Arrays.asList("g", "h", "i"));
        }
        if (c == '5') {
            return new ArrayList<>(Arrays.asList("j", "k", "l"));
        }
        if (c == '6') {
            return new ArrayList<>(Arrays.asList("m", "n", "o"));
        }
        if (c == '7') {
            return new ArrayList<>(Arrays.asList("p", "q", "r", "s"));
        }
        if (c == '8') {
            return new ArrayList<>(Arrays.asList("t", "u", "v"));
        }
        if (c == '9') {
            return new ArrayList<>(Arrays.asList("w", "x", "y", "z"));
        }
        return Collections.emptyList();
    }
}
