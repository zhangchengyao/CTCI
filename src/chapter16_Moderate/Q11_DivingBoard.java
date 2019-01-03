package chapter16_Moderate;

import java.util.HashSet;

public class Q11_DivingBoard {
    HashSet<Integer> allLengths(int k, int shorter, int longer){
        HashSet<Integer> res = new HashSet<>();
        for(int nShort = 0; nShort<=k; nShort++){
            int nLong = k - nShort;
            res.add(nShort*shorter + nLong*longer);
        }
        return res;
    }
}
