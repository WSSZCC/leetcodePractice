package test.leetcode2024;

/**
 * 找到连续赢 K 场比赛的第一位玩家
 */
public class FindWinningPlayer {
    public int findWinningPlayer(int[] skills, int k) {
        int pre=0;
        int count =0;
        for(int i=1;i<skills.length;i++){
            if(skills[pre]>skills[i]){
                count++;
                if(count>=k){
                    return pre;
                }
            }else{
                count=1;
                pre=i;
                if(count>=k){
                    return pre;
                }
            }
        }
        return pre;
    }
}
