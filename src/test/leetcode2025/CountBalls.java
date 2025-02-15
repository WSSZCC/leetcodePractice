package test.leetcode2025;

/**
 * 两球之间的磁力
 */
public class CountBalls {
    public int countBalls(int lowLimit, int highLimit) {
        int[] ints = new int[10000];
        int max=Integer.MIN_VALUE;
        for (int i = lowLimit;i<=highLimit;i++){
            int index = 0;
            while (i>0){
                index+=i%10;
                i/=10;
                System.out.println(i);
            }
            ints[index]++;
            max = Math.max(max,ints[index]);
        }
        return max;
    }
}
