package test.leetcode2025;

/**
 * 找到初始输入字符串 I
 */
public class PossibleStringCount {
    public int possibleStringCount(String word) {
        int length = word.length();
        int ans = 0;
        char pre = word.charAt(0);
        int flag = 0;
        for (int i = 0; i < length; i++) {
            if(pre!=word.charAt(i)){
                if(flag>1){
                    ans-=ans>0?1:0;
                    ans+=flag;
                }
                flag=1;
                pre = word.charAt(i);
            }else {
                flag++;
            }
        }

        if(flag>1){
            ans-=ans>0?1:0;
            ans+=flag;
        }
        return ans==0?1:ans;
    }
}
