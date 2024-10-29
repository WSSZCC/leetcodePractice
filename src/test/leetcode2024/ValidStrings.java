package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成不含相邻零的二进制字符串
 */
public class ValidStrings {
    private  List<String> list;
    public  List<String> validStrings(int n) {
        list = new ArrayList<>();
        dfs(n-1,"",0);
        dfs(n-1,"",1);
        return list;
    }

    private void dfs(int n, String s,int flag) {
        if(n==0){
            list.add(s+flag);
            return;
        }
        if(flag==1){
            dfs(n-1,s+flag,0);
        }
        dfs(n-1,s+flag,1);
    }
}
