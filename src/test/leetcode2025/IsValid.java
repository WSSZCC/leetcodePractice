package test.leetcode2025;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 有效单词
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        isValid.isValid("#zwI");
    }
    public boolean isValid(String word) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        Set<Character> set1 = new HashSet<>(Arrays.asList('@','#','$'));
        boolean isTrue = false;
        boolean isTrue1 = false;
        for (char c : word.toCharArray()) {
            if(set.contains(c)){
                isTrue = true;
                continue;
            }
            if(set1.contains(c)){
               return false;
            }
            if((c-'a'>=0&&c-'a'<26) || (c-'A'>=0&&c-'A'<26) ){
                isTrue1 =true;
            }
        }
        if(word.length()<3){
            return false;
        }
        return isTrue&&isTrue1;
    }
}
