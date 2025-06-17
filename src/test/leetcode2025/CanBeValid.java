package test.leetcode2025;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 */
public class CanBeValid {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0){
            return false;
        }
        int v1 = 0;
        int v2 = 0;
        char[] chars = locked.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1'){
                int v3 = 1-s.charAt(i)%2*2;
                v2+=v3;
                if(v2<0){
                    return false;
                }
                v1+=v3;
            }else {
                v2++;
                v1--;
            }
        }
        if(v1<0){
            v1=1;
        }
        return v1==0;
    }
    public boolean canBeValid1(String s, String locked) {
        if(s.length()%2!=0){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] locks = locked.toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if(locks[i]=='1') {
                if (chars[i] == ')' && !list.isEmpty() && chars[list.peekLast()] == '(') {
                    list.pollLast();
                    continue;
                }
                list.addLast(i);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if(locks[i]=='0'){
                list.add(i);
            }
        }
        Collections.sort(list);
        LinkedList<Character> list1 = new LinkedList<>();
        for (Integer integer : list) {
            char aChar = chars[integer];
            if (aChar == ')' && !list1.isEmpty() && list1.peekLast() == '(') {
                list1.pollLast();
                continue;
            }
            if (list1.isEmpty()) {
                if( aChar == ')' && locks[integer] == '1') {
                    return false;
                }
                list1.addLast('(');
            }else {
                if(locks[integer] == '0'||aChar==')'){
                    list1.pollLast();
                }else {
                    list1.addLast('(');
                }
            }
        }
        return list1.isEmpty();
    }
}
