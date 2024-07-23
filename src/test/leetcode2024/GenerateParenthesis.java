package test.leetcode2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 括号生成
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
    }
    private  int len;
    private  List<String> list = new ArrayList<>();
    private  char[] chars;
    public  List<String> generateParenthesis(int n) {
        len=n;
        chars = new char[len*2];
        dfs(0,0);
        return list;
    }

    private  void dfs(int i, int node) {
        if(i==len*2){
            list.add(new String(chars));
            return;
        }
        if(node<len){
            chars[i]='(';
            dfs(i+1,node+1);
        }
        if(i-node<node){
            chars[i] = ')';
            dfs(i+1,node);
        }
    }

    /**
     * @param list
     * @param count
     * @param set
     * @param sb
     * @param stack
     * @param ansList
     * 粗糙的回溯
     */
    private static void backtrack(List<Character> list, int count, Set<Integer> set, StringBuilder sb, LinkedList<Character> stack, List<String> ansList) {
        if (!stack.isEmpty() && stack.peek() == ')') {
            return;
        }
        if (count == 0 && stack.isEmpty()) {
            ansList.add(sb.toString());
           return;
        }
        for (int j = 0; j < list.size(); j++) {
            if (!set.contains(j)) {
                boolean isChange = false;
                Character c = list.get(j);
                if (stack.isEmpty()) {
                    stack.add(c);
                } else {
                    if (stack.peekLast() == '(' && c == ')') {
                        stack.pollLast();
                        isChange = true;
                    } else {
                        stack.add(c);
                    }
                }
                set.add(j);
                count--;
                sb.append(c);
                backtrack(list,count,set,sb,stack,ansList);
                if(isChange){
                    stack.add('(');
                }else {
                    stack.pollLast();
                }
                set.remove(j);
                sb.deleteCharAt(sb.length()-1);
                count++;
            }
        }

    }
}
