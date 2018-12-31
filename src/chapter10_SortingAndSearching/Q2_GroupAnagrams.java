package chapter10_SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q2_GroupAnagrams {
    void groupAnagrams(String[] arr){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: arr){
            String converted = convert(s);
            if(!map.containsKey(converted)) map.put(converted, new ArrayList<>());
            map.get(converted).add(s);
        }

        int index = 0;
        for(List<String> ana: map.values()){
            for(String s: ana){
                arr[index++] = s;
            }
        }
    }

    private String convert(String s){
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return String.valueOf(str);
    }
}
