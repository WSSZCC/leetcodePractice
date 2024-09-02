package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 考试的最大困扰度
 */
public class MaxConsecutiveAnswers {
    public static void main(String[] args) {
        maxConsecutiveAnswers("FFTFTTTFFF", 1);
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int needMaxLen = n - k;
        if (needMaxLen == 0) {
            return n;
        }
        int t = calMaxLen(answerKey, k, n, 'T');
        int f = calMaxLen(answerKey, k, n, 'F');
        return Math.max(t,f);

    }

    private static int calMaxLen(String answerKey, int k, int n,char c) {
        int count = 0;
        Deque<Integer> queue = new LinkedList<>();
        int flag = k;
        int targetCount = 0;
        int left = -1;
        for (int i = 0; i < n; i++) {
            if (answerKey.charAt(i) == c) {
                if (flag == 0 && queue.isEmpty()) {
                    flag = k;
                    targetCount = 0;
                    continue;
                }
                if (flag == 0) {
                    Integer poll = queue.poll();
                    targetCount -= poll -left;
                    left=poll;
                } else {
                    flag--;
                }
                queue.add(i);

            }
            targetCount++;
            count = Math.max(count, targetCount);
        }
        return count;
    }
}
