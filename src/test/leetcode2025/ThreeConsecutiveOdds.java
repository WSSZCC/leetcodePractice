package test.leetcode2025;

/**
 * 存在连续三个奇数的数组
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if((i&1)==0){
                count = 0;
            }else {
                count++;
            }
            if(count==3){
                return true;
            }
        }
        return false;
    }
}
