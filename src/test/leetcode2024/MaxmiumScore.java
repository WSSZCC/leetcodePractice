package test.leetcode2024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 心算挑战
 */
public class MaxmiumScore {
    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        int sum = 0;
        Arrays.sort(cards);
        int curMinOddIndex = -1;
        int curMinEvenIndex = -1;
        for (int i = n - cnt; i < n; i++) {
            sum += cards[i];
            if (cards[i] % 2 == 0) {
                if (curMinEvenIndex == -1) {
                    curMinEvenIndex = i;
                }
            } else {
                if (curMinOddIndex == -1) {
                    curMinOddIndex = i;
                }
            }
        }
        if (sum % 2 == 0) {
            return sum;
        }
        int maxSum = 0;
        for (int i = n - cnt - 1; i >= 0; i--) {
            if(cards[i]%2==0&&curMinOddIndex!=-1){
                maxSum = Math.max(maxSum,sum-cards[curMinOddIndex]+cards[i]);
                curMinOddIndex = -1;
            }
            if(cards[i]%2!=0&&curMinEvenIndex!=-1){
                maxSum = Math.max(maxSum,sum-cards[curMinEvenIndex]+cards[i]);
                curMinEvenIndex = -1;
            }
            if(curMinEvenIndex==-1&&curMinOddIndex==-1){
                break;
            }
        }
        return maxSum;
    }
}
