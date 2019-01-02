package chapter16_Moderate;

import java.util.HashMap;

public class Q2_WordFrequencies {
    private HashMap<String, Integer> freq = new HashMap<>();

    int getFrequent(String[] words, String word){
        if(freq.isEmpty()) buildFreqTable(words);
        return freq.get(word.toLowerCase());
    }

    private void buildFreqTable(String[] words){
        for(String word: words){
            word = word.toLowerCase();
            if(word.trim().length()>0){
                freq.put(word, freq.getOrDefault(word, 0)+1);
            }
        }
    }
}
