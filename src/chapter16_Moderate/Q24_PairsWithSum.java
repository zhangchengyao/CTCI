package chapter16_Moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q24_PairsWithSum {
    List<int[]> pairSums(int[] a, int sum){
        List<int[]> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: a){
            int complement = sum - x;
            if(map.getOrDefault(complement, 0)>0){
                res.add(new int[]{x, complement});
                map.put(complement, map.get(complement)-1);
            } else {
                map.put(x, map.getOrDefault(x, 0)+1);
            }
        }
        return res;
    }
}
