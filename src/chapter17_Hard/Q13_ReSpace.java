package chapter17_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q13_ReSpace {
    class Result{
        List<String> parsed;
        int invalid;

        Result(List<String> _parsed, int i){
            parsed = _parsed;
            invalid = i;
        }
    }
    List<String> unconcatenate(String document, HashSet<String> dictionary){
        Result res = splitDocument(document, dictionary, 0, new HashMap<>());
        return res.parsed;
    }

    private Result splitDocument(String document, HashSet<String> dictionary, int offset, HashMap<Integer, Result> memo){
        if(offset>=document.length()) return new Result(new ArrayList<>(), 0);
        if(memo.containsKey(offset)) return memo.get(offset);

        List<String> best = new ArrayList<>();
        int bestInvalid = Integer.MAX_VALUE;

        for(int i=offset;i<document.length();i++){
            String word = document.substring(offset, i+1);
            int invalid = 0;
            if(!dictionary.contains(word)) invalid = i-offset+1;

            if(invalid>=bestInvalid) continue;

            Result result = splitDocument(document, dictionary, i+1, memo);
            if(invalid+result.invalid<bestInvalid){
                bestInvalid = invalid + result.invalid;
                best = new ArrayList<>(result.parsed);
                best.add(0, word);
            }
        }

        Result res = new Result(best, bestInvalid);
        memo.put(offset, res);
        return res;
    }
}
