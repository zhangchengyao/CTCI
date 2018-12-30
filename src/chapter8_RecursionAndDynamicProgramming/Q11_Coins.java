package chapter8_RecursionAndDynamicProgramming;

public class Q11_Coins {
    int makeChange(int n){
        int[] denoms = {25, 10, 5, 1};
        int[][] memo = new int[n+1][denoms.length];
        return makeChange(n, denoms, 0, memo);
    }
    private int makeChange(int n, int[] denoms, int index, int[][] memo){
        if(index>=denoms.length-1) return 1;

        if(memo[n][index]>0) return memo[n][index];

        int amount = denoms[index];
        for(int i=0;i*amount<=n;i++){
            memo[n][index] += makeChange(n-i*amount, denoms, index+1, memo);
        }
        return memo[n][index];
    }
}