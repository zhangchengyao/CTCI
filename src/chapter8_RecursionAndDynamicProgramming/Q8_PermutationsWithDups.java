package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q8_PermutationsWithDups {
    List<String> permutation(String s){
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> counts = buildFreqTable(s);
        getPermu(counts, "", s.length(), res);
        return res;
    }

    private HashMap<Character, Integer> buildFreqTable(String s){
        HashMap<Character, Integer> counts = new HashMap<>();
        for(char c: s.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0)+1);
        }
        return counts;
    }

    private void getPermu(HashMap<Character, Integer> counts, String prefix, int remaining, List<String> res){
        if(remaining==0){
            res.add(prefix);
            return ;
        }
        for(Character c: counts.keySet()){
            if(counts.get(c)>0){
                counts.put(c, counts.get(c)-1);
                getPermu(counts, prefix+c, remaining-1, res);
                counts.put(c, counts.get(c)+1);
            }
        }
    }
}
