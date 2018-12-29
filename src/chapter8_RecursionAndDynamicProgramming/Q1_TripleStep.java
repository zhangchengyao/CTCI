package chapter8_RecursionAndDynamicProgramming;

import java.util.Arrays;

public class Q1_TripleStep {
    int waysOfHops(int n){
        if(n<0) return 0;
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;

        int prev3 = 1;
        int prev2 = 2;
        int prev1 = 4;
        int res = 0;
        for(int i=4;i<=n;i++){
            res = prev3 + prev2 + prev1;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = res;
        }
        return res;
    }

    int countWays(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }
    private int countWays(int n, int[] memo){
        if(n<0) return 0;
        else if(n==0) return 1;
        else if(memo[n]>-1) return memo[n];
        else{
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }
}
