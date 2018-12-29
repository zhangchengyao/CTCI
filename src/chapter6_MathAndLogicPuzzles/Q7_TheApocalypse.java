package chapter6_MathAndLogicPuzzles;

import java.util.Random;

public class Q7_TheApocalypse {
    double getRatio(int n){
        int boys = 0;
        int girls = 0;
        for(int i=0;i<n;i++){
            int[] babies = runOneFamily();
            boys += babies[0];
            girls += babies[1];
        }
        return girls*1.0/boys;
    }

    int[] runOneFamily(){
        int boys = 0;
        Random rand = new Random();
        while(rand.nextBoolean()){
            boys++;
        }
        return new int[]{boys, 1};
    }
}
