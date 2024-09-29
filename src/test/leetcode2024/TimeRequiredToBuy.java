package test.leetcode2024;

/**
 * 买票需要的时间
 */
public class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int sum = tickets[k];
        if(n==1){
            return sum;
        }
        for (int i = 0; i < k; i++) {
            sum+=Math.min(tickets[i],tickets[k]);
        }
        for (int i = k+1; i < n; i++) {
            sum+=Math.min(tickets[i],tickets[k]-1);
        }
        return sum;
    }
}
