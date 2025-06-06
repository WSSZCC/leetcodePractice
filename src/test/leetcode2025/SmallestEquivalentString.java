package test.leetcode2025;

import java.util.Arrays;

public class SmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] ints = new int[26];

        int n = s1.length();
        for (int i = 0; i < 26; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            merag(ints,x,y);
        }
        char[] chars = baseStr.toCharArray();
        for (int i = 0; i < baseStr.length(); i++) {
            chars[i] = (char) (find(ints,chars[i]-'a')+'a');
        }
        return new String(chars);
    }

    private void merag(int[] ints, int x, int y) {
        int x1 = find(ints, x);
        int y1 = find(ints, y);
        if(x1<y1){
            ints[y1]=x1;
        }else {
            ints[x1] = y1;
        }
    }

    private int find(int[] ints,int x){
        if(ints[x]!=x){
            ints[x] = find(ints,ints[x]);
        }
        return ints[x];
    }

}
