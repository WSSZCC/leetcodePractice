package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复原 IP 地址
 */
public class RestoreIpAddresses {
    private static List<String> list;

    public static void main(String[] args) {
        String s = "056";
        System.out.println(Integer.parseInt(s));
        System.out.println(restoreIpAddresses("255255111256"));

    }

    public static List<String> restoreIpAddresses(String s) {
        int n = s.length();
        list = new ArrayList<>();
        if (n < 4 || n > 12) {
            return list;
        }
        backtrack(0, n, 4, new ArrayList<>(), s);
        return list;
    }

    private static void backtrack(int index, int n, int flag, List<String> currentList, String s) {
        if (flag == 1) {
            int len = n - index;
            String substring = s.substring(index, n);
            if (len < 4 && len > 0 && !(len > 1 && (substring.charAt(0)=='0'||Integer.parseInt(substring)>255))) {
                String collect = String.join(".", currentList);
                list.add(collect + "." + substring);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(index+i>=n){
                break;
            }
            String substring = s.substring(index, index + i);
            if(substring.length()>1&&(substring.charAt(0)=='0'||Integer.parseInt(substring)>255)){
               continue;
            }
            currentList.add(substring);
            backtrack(index+i,n,flag-1,currentList,s);
            currentList.remove(currentList.size()-1);
        }
    }
}
