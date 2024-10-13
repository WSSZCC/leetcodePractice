package test.leetcode2024;

/**
 * 鸡蛋掉落-两枚鸡蛋
 */
public class TwoEggDrop {
    public static void main(String[] args) {
        System.out.println(twoEggDrop(4));
    }
    public static int twoEggDrop(int n) {
        return calCount(n,0);
    }

    private static int calCount(int n, int count) {
        if(n<=count){
            return count;
        }
        return calCount(n-count,count+1);
    }
}
