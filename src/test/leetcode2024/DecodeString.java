package test.leetcode2024;

import java.util.*;

/**
 * 字符串解码
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println( decodeString(s));
    }

    public static String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        List<Character> stingList = new ArrayList<>();
        Deque<Character> numberStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c!=']'){
                stack.push(c);
            }
            if(c==']'){
                while (!stack.isEmpty()&&stack.peek()!='['){
                    stingList.add(stack.pop());
                }
                stack.pop();
                while (!stack.isEmpty()&&Character.isDigit(stack.peek())){
                    numberStack.push(stack.pop());
                }
                String numberString = getStringByStack(numberStack);
                int count = numberString.equals("")?1:Integer.parseInt(numberString);
                Collections.reverse(stingList);
                for (int i = 0; i < count; i++) {
                    for (Character character : stingList) {
                        stack.push(character);
                    }
                }
                stingList = new ArrayList<>();
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();

    }

    private static String getStringByStack(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
