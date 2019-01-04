package chapter16_Moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q20_T9 {
    private static final char[][] keyboard = {null, null, {'a','b','c'},{'d','e','f'},
                        {'g','h','i'},{'j','k','l'},{'m','n','o','p'},
                        {'q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    private HashMap<String, List<String>> numberToWords;

    List<String> getWords(String number, HashSet<String> dictionary){
        if(numberToWords==null) numberToWords = preprocess(dictionary);
        return numberToWords.get(number);
    }

    private HashMap<Character, Integer> mapCharToDigit(){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=2;i<keyboard.length;i++){
            for(char c: keyboard[i]){
                map.put(c, i);
            }
        }
        return map;
    }

    private HashMap<String, List<String>> preprocess(HashSet<String> dictionary){
        HashMap<Character, Integer> charToDigit = mapCharToDigit();
        HashMap<String, List<String>> res = new HashMap<>();

        for(String word: dictionary){
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()){
                sb.append(charToDigit.get(c));
            }
            res.putIfAbsent(sb.toString(), new ArrayList<>());
            res.get(sb.toString()).add(word);
        }

        return res;
    }
}
