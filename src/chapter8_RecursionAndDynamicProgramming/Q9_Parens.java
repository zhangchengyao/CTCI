package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Q9_Parens {
    List<String> validParens(int n){
        List<String> res = new ArrayList<>();
        helper("", n, n, res);
        return res;
    }

    private void helper(String str, int openRemaining, int closeRemaining, List<String> res){
        if(closeRemaining==0){
            res.add(str);
            return ;
        }

        if(openRemaining==closeRemaining){
            helper(str+"(", openRemaining-1, closeRemaining, res);
        } else {
            if(openRemaining>0) helper(str+"(", openRemaining-1, closeRemaining, res);
            helper(str+")", openRemaining, closeRemaining-1, res);
        }
    }
}
