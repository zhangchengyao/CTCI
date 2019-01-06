package chapter17_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17_MultiSearch {
    HashMap<String, List<Integer>> searchAll(String big, String[] smalls){
        Trie trie = buildTrie(smalls);

        HashMap<String, List<Integer>> res = new HashMap<>();

        for(int i=0;i<big.length();i++){
            List<String> words = trie.search(big.substring(i));
            for(String word: words){
                res.putIfAbsent(word, new ArrayList<>());
                res.get(word).add(i);
            }
        }

        return res;
    }

    private Trie buildTrie(String[] strs){
        Trie trie = new Trie();
        for(String s: strs){
            trie.insert(s);
        }
        return trie;
    }

    class Trie{
        Node root;

        Trie(){
            root = new Node();
        }

        void insert(String s){
            Node cur = root;
            for(char c: s.toCharArray()){
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.word = s;
        }

        List<String> search(String s){
            Node cur = root;
            List<String> res = new ArrayList<>();
            for(char c: s.toCharArray()){
                if(!cur.children.containsKey(c)) return res;
                cur = cur.children.get(c);
                if(cur.word!=null) res.add(cur.word);
            }
            return res;
        }
    }

    class Node{
        HashMap<Character, Node> children;
        char val;
        String word;

        Node(){
            children = new HashMap<>();
        }

        Node(char _val){
            children = new HashMap<>();
            val = _val;
        }
    }
}
