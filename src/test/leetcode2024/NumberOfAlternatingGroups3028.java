package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 交替组 II
 */
public class NumberOfAlternatingGroups3028 {
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1,0},3));
    }
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;
        int index = 0;
        int n = colors.length;
        boolean isTrue = true;
        while (index<n){
            int pre = colors[index];
            if(index!=0&&isTrue&&(colors[(k+index-2)%n]!=colors[(k+index-1)%n])){
                index++;
                ans++;
                continue;
            }
            for (int j = 1; j < k; j++) {
                int d = (index + j) % n;
                if(pre==colors[d]){
                    index = d<index?n:d;
                    isTrue=false;
                    break;
                }
                pre = colors[d];
                if(j==k-1){
                    isTrue = true;
                }
            }
            if(isTrue){
                ans++;
                index++;
            }

        }
        return ans;
    }
    public int numberOfAlternatingGroups1(int[] colors, int k) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int value = 1;
        for (int i = 0; i < k; i++) {
            sb1.append(value);
            value = 1-value;
            sb2.append(value);
        }
        List<String> list = Arrays.asList(sb1.toString(), sb2.toString());
        int ans = 0;
        int n = colors.length;
        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb3.append(colors[i]);
        }
        if(list.contains(sb3.toString())){
            ans++;
        }
        for (int i = 1; i < n; i++) {
            sb3.deleteCharAt(0);
            sb3.append(colors[k%n]);
            k++;
            if(list.contains(sb3.toString())){
                ans++;
            }
        }
        return ans;
    }
}
