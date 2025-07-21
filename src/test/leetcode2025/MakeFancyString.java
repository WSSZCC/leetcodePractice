package test.leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除字符使字符串变好
 */
public class MakeFancyString {
    public static void main(String[] args) {
        MakeFancyString makeFancyString = new MakeFancyString();
        makeFancyString.makeFancyString("aaabaaaa");
    }
    public String makeFancyString(String s) {
        List<Character> list = new ArrayList<>();
        char preC = ' ';
        int flag = 0;
        for (char c : s.toCharArray()) {
            if(preC == ' '){
                preC = c;
            }
            if(preC==c){
                flag++;
                if(flag>=3){
                    continue;
                }
            }else {
                flag = 0;
            }
            preC = c;
            list.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();

    }
}
