package test.leetcode2025;

import java.util.HashMap;

public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(pushDominoes("RR.L"));
    }
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] chars = new char[n + 2];
        chars[0] = 'L';
        chars[n+1] = 'R';
        int index = 1;
        for (char c : dominoes.toCharArray()) {
            chars[index]=c;
            index++;
        }
        pushChar(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static void pushChar(char[] chars) {
        int pre = 0 ;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar!='.'){
                if(count ==0){
                    pre = i;
                    continue;
                }
                if(chars[pre]=='R'&&aChar=='R'){
                    for (int j = pre +1; j < i; j++) {
                        chars[j]='R';
                    }
                    count = 0;
                    pre =i;
                    continue;
                }
                if(chars[pre]=='L'){
                    if(aChar=='L'){
                        for (int j = pre +1; j < i; j++) {
                            chars[j]='L';
                        }
                    }
                    count =0;
                    pre =i;
                    continue;
                }
                int left = pre +1;
                int right = i-1;
                while (left<right){
                    chars[left]='R';
                    chars[right]='L';
                    left++;
                    right--;
                }
                count =0;
                pre =i;
            }else {
                count++;
            }
        }
    }
}
