package test.leetcode2024;

import java.util.*;

/**
 * 实现 Trie (前缀树)
 */
class TrieNode {
    boolean isTrue;
    Map<Character, TrieNode> node;
    Map<String, List<String>> value;

    TrieNode() {
        isTrue = false;
        node = new HashMap<>();
        value = new HashMap<>();
    }
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trieNode = root;
        String s = "";
        for (char c : word.toCharArray()) {
            s = String.format("%s%s", s, c);
            if(!trieNode.node.containsKey(c)){
                trieNode.node.put(c,new TrieNode());
                trieNode.value.put(s,new ArrayList<>(Collections.singletonList(word)));
            }else {
                List<String> list = trieNode.value.get(s);
                list.add(word);
                Collections.sort(list);
                if(list.size()>3){
                    list.subList(3,list.size()).clear();
                }
                trieNode.value.put(s,list);
            }
            trieNode = trieNode.node.get(c);
        }
        trieNode.isTrue = true;
    }

    public List<String> searchValue(String word) {
        TrieNode trieNode = root;
        List<String> list = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if(trieNode.node.get(c)==null){
                return Collections.emptyList();
            }
            list = trieNode.value.get(word);
            trieNode = trieNode.node.get(c);
        }

        return list;
    }

    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            if(trieNode.node.get(c)==null){
                return false;
            }
            trieNode = trieNode.node.get(c);
        }

        return trieNode.isTrue;
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char c : prefix.toCharArray()) {
            if(trieNode.node.get(c)==null){
                return false;
            }
            trieNode = trieNode.node.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
