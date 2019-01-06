package chapter17_Hard;

import java.util.Arrays;
import java.util.HashSet;

public class Q15_LongestWord {
    String longestWord(String[] words){
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        Arrays.sort(words, (a,b)->b.length()-a.length());
        HashSet<String> failed = new HashSet<>();
        for(String str: words){
            if(canBuild(str, true, set, failed)){
                return str;
            }
        }
        return null;
    }

    private boolean canBuild(String word, boolean isOriginWord, HashSet<String> dic, HashSet<String> failed){
        if(dic.contains(word) && !isOriginWord) return true;
        if(failed.contains(word)) return false;

        for(int i=1;i<word.length();i++){
            String leading = word.substring(0, i);
            if(dic.contains(leading)){
                String remaining = word.substring(i);
                if(canBuild(remaining, false, dic, failed)) return true;
            }
        }

        failed.add(word);
        return false;
    }
}
