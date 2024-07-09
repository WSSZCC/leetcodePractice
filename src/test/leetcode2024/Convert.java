package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Z 字形变换
 */
public class Convert {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        int n = s.length();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list1 = new ArrayList<>();
            list.add(list1);
        }
        int index = 0;
        while (index < n) {
            for (int i = 0; i < numRows; i++) {
                if (index < n) {
                    List<Integer> list1 = list.get(i);
                    list1.add(index);
                    list.set(i, list1);
                }
                index++;
            }
            for (int i = 1; i < numRows - 1; i++) {
                if (index < n) {
                    List<Integer> list1 = list.get(numRows - 1 - i);
                    list1.add(index);
                    list.set(numRows - 1 - i, list1);
                }
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list.stream().flatMap(List::stream).collect(Collectors.toList())) {
            sb.append(s.charAt(integer));
        }
        return sb.toString();
    }
}
