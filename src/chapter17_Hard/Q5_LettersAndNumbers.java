package chapter17_Hard;

import java.util.HashMap;

public class Q5_LettersAndNumbers {
    char[] longestSubarray(char[] array){
        if(array==null || array.length<2) return null;

        int[] deltas = new int[array.length];
        int delta = 0; // # letter - # digit
        for(int i=0;i<array.length;i++){
            if(Character.isLetter(array[i])) delta++;
            else delta--;
            deltas[i] = delta;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for(int i=0;i<array.length;i++){
            if(map.containsKey(deltas[i])){
                int curLen = i-map.get(deltas[i]);
                if(curLen>maxLen){
                    maxLen = curLen;
                    start = map.get(deltas[i]) + 1;
                }
            } else {
                map.put(deltas[i], i);
            }
        }

        char[] res = new char[maxLen];
        for(int i=0;i<maxLen;i++){
            res[i] = array[start+i];
        }
        return res;
    }
}
