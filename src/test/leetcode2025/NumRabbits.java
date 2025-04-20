package test.leetcode2025;


/**
 * 森林中的兔子
 */
public class NumRabbits {
    public int numRabbits(int[] answers) {
        int[] ints = new int[1000];
        int ans = 0;
        for (int answer : answers) {
           if(ints[answer]==0){
               ans+=answer+1;
               ints[answer]=answer;
               continue;
           }
           ints[answer]--;
        }
        return ans;
    }
}
