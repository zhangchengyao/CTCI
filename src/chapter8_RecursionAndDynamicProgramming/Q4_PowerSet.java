package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Q4_PowerSet {
    List<List<Integer>> powerSet(List<Integer> set){
        if(set.isEmpty()){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        int first = set.remove(0);
        List<List<Integer>> res = powerSet(set);
        List<List<Integer>> more = new ArrayList<>();
        for(List<Integer> subset: res){
            List<Integer> tmp = new ArrayList<>(subset);
            tmp.add(first);
            more.add(tmp);
        }
        res.addAll(more);
        return res;
    }

    List<List<Integer>> powerSet2(List<Integer> set){
        List<List<Integer>> res = new ArrayList<>();

        for(int num=0;num<(1<<set.size());num++){
            List<Integer> subset = convertBinaryToSet(num, set);
            res.add(subset);
        }

        return res;
    }

    private List<Integer> convertBinaryToSet(int num, List<Integer> set){
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while(num!=0){
            if((num&1)==1) res.add(set.get(idx));
            idx++;
            num >>>= 1;
        }
        return res;
    }
}
