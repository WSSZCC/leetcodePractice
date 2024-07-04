package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索推荐系统
 */
public class SuggestedProducts {
    public static void main(String[] args) {
        suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad","ac"},"mouse");

    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        String[] split = searchWord.split("");
        String str = "";
        for (String s : split) {
            str = String.format("%s%s", str, s);
            List<String> list1 = trie.searchValue(str);
            list.add(list1);
        }
        return list;
    }
}
