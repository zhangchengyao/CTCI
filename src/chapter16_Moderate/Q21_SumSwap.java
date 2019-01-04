package chapter16_Moderate;

import java.util.HashSet;

public class Q21_SumSwap {
    int[] swapValuesFromTwoArray(int[] a, int[] b){
        HashSet<Integer> set  = new HashSet<>();
        int sumA = 0;
        int sumB = 0;

        for(int num: a){
            sumA += num;
        }
        for(int num: b){
            sumB += num;
            set.add(num);
        }

        if((sumA+sumB)%2!=0) return null;

        int k = (sumB-sumA)/2; // big-small = k

        int[] res = new int[2];
        for(int num: a){
            if(set.contains(num+k)){
                res[0] = num;
                res[1] = num+k;
                break;
            }
        }
        return res;
    }
}
