package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Q7_PermutationsWithoutDups {
    List<String> permutation(String str){
        return permutation(new StringBuilder(str));
    }
    private List<String> permutation(StringBuilder sb){
        List<String> res = new ArrayList<>();
        if(sb.length()==0){
            res.add("");
            return res;
        }

        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            List<String> permutationOfSubStr = permutation(sb);
            for(String permu: permutationOfSubStr){
                res.add(c+permu);
            }
            sb.insert(i, c);
        }

        return res;
    }
}
