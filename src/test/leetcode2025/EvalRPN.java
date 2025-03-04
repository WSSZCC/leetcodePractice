package test.leetcode2025;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] strings = {"4", "13", "5", "/", "+"};
        evalRPN(strings);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> list = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*":
                    Integer a = list.pop();
                    Integer b = list.pop();
                    list.push(a * b);
                    break;
                case "/":
                    Integer a1 = list.pop();
                    Integer b1 = list.pop();
                    list.push(b1 / a1);
                    break;
                case "-":
                    Integer a2 = list.pop();
                    Integer b2 = list.pop();
                    list.push(b2 - a2);
                    break;
                case "+":
                    Integer a3 = list.pop();
                    Integer b3 = list.pop();
                    list.push(a3 + b3);
                    break;
                default:
                    list.push(Integer.parseInt(token));
            }
        }
        return list.peek();
    }
}
