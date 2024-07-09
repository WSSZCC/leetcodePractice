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
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        int index = 0;
        while (index < n) {
            for (int i = 0; i < numRows; i++) {
                if (index < n) {
                    StringBuilder sb= list.get(i);
                    sb.append(s.charAt(index));
                    list.set(i, sb);
                }
                index++;
            }
            for (int i = 1; i < numRows - 1; i++) {
                if (index < n) {
                    StringBuilder sb= list.get(numRows - 1 - i);
                    sb.append(s.charAt(index));
                    list.set(numRows - 1 - i, sb);
                }
                index++;
            }
        }
        return String.join("", list);
    }
}
