package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 小行星碰撞
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(asteroidCollision(new int[]{-2,-1,1,2}));

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            boolean isTrue = true;
            while (!stack.isEmpty()&&stack.peek()>0&&asteroid<0){
                if(stack.peek()>=Math.abs(asteroid)){
                    if(stack.peek()==Math.abs(asteroid)){
                        stack.pop();
                    }
                    isTrue = false;
                    break;
                }
                stack.pop();
            }
            if(isTrue){
                stack.push(asteroid);
            }
        }
        int n = stack.size();
        int[] ints = new int[n];
        int i = 0;
        while (!stack.isEmpty()){
            ints[i] = stack.pollLast();
            i++;
        }
        return ints;
    }
}
