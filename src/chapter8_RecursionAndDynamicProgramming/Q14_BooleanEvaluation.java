package chapter8_RecursionAndDynamicProgramming;

import java.util.HashMap;

public class Q14_BooleanEvaluation {
    int countEval(String expression, boolean result){
        HashMap<String, Integer> memo = new HashMap<>();
        return countEval(expression, result, memo);
    }

    private int countEval(String expression, boolean result, HashMap<String, Integer> memo){
        if(expression.length()==1){
            if((Integer.parseInt(expression)==1 && result) ||
               (Integer.parseInt(expression)==0 && !result)) return 1;
            else return 0;
        }
        String str = expression+" "+result;
        if(memo.containsKey(str)) return memo.get(str);

        int ways = 0;
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(!Character.isDigit(c)){
                int leftTrue = countEval(expression.substring(0, i), true, memo);
                int leftFalse = countEval(expression.substring(0, i), false, memo);
                int rightTrue = countEval(expression.substring(i+1), true, memo);
                int rightFalse = countEval(expression.substring(i+1), false, memo);

                int total = (leftTrue+leftFalse) * (rightTrue+rightFalse);

                int totalTrue;
                if(c=='&') totalTrue = leftTrue * rightTrue;
                else if(c=='|') totalTrue = leftTrue*rightTrue + leftFalse*rightTrue + leftTrue*rightFalse;
                else totalTrue = leftTrue*rightFalse + leftFalse*rightTrue;

                ways += result?totalTrue:total-totalTrue;
            }
        }
        memo.put(str, ways);
        return ways;
    }

}
