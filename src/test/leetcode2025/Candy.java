package test.leetcode2025;

/**
 * 分发糖果
 */
public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,6,10,8,7,3,2}));
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            int begin = i;
            if(i>0&&ratings[i-1]>ratings[i]){
                begin--;
            }
            while (i+1<n&&ratings[i]<ratings[i+1]){
                i++;
            }
            int top = i;
            while (i+1<n&&ratings[i]>ratings[i+1]){
                i++;
            }
            int v1 = top - begin;
            int v2 = i - top;
            ans += (v1) *(v1 +1)/2+ (v2) * (v2+1)/2;
            ans-=Math.min(v2,v1);
        }
        return ans;
    }
}
