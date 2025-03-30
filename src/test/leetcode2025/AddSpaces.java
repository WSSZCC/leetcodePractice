package test.leetcode2025;

/**
 * 向字符串添加空格
 */
public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int flag =0;
        for (int space : spaces) {
            sb.insert(space+flag,' ');
            flag++;
        }
        return sb.toString();
    }
}
