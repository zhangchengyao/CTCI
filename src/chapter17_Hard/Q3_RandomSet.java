package chapter17_Hard;

import java.util.Random;

public class Q3_RandomSet {
    int[] pickMRandomly(int[] array, int m){
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            res[i] = array[i];
        }

        Random rand = new Random();
        for(int i=m;i<array.length;i++){
            int k = rand.nextInt(i+1);
            if(k<m) res[k] = array[i];
        }

        return res;
    }
}
