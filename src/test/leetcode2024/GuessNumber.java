package test.leetcode2024;

/**
 * 猜数字大小
 */
public class GuessNumber {
    public static void main(String[] args) {
        guessNumber(2126753390);
    }

    private static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int guess = guess(i);
            if (guess == 0) {
                return i;
            }
            if (guess == -1) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }

    private static int guess(int n) {
        return Integer.compare(1702766719, n);
    }
}
