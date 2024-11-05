package test.leetcode2024;

/**
 * 求出硬币游戏的赢家
 */
public class LosingPlayer {
    public String losingPlayer(int x, int y) {
        int i = Math.min(y / 5,x);
        if(i%2==0){
            return "Bob";
        }
        return "Alice";

    }
}
