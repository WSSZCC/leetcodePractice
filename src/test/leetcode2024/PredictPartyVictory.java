package test.leetcode2024;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Dota2 参议院
 */
public class PredictPartyVictory {
    public static void main(String[] args) {
        predictPartyVictory("RRDDDR");
    }

    public static String predictPartyVictory(String senate) {
        Queue<Character> queue = new ArrayDeque<>();
        Queue<Character> queue1 = new ArrayDeque<>();
        for (char c : senate.toCharArray()) {
            if (!queue.isEmpty() && c != queue.peek()) {
                queue1.add(queue.remove());
            } else {
                queue.add(c);
            }
        }
        boolean isChange = false;
        while (!isChange) {
            isChange = true;
            queue.addAll(queue1);
            queue1.clear();
            Queue<Character> queue2 = new ArrayDeque<>();
            for (Character character : queue) {
                if (!queue1.isEmpty() && character != queue1.peek()) {
                    queue2.add(queue1.remove());
                    isChange = false;
                } else {
                    queue1.add(character);
                }
            }
            queue.clear();
            queue1.addAll(queue2);
        }

        return "Dire";

    }
}
