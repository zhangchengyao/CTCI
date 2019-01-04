package chapter16_Moderate;

import java.util.HashSet;

public class Test {
    public static void main(String[] args){
        int[] a = {4,1,2,1,1,2};
        int[] b = {3,6,3,3};
        int[] res = new Q21_SumSwap().swapValuesFromTwoArray(b,a);
        System.out.println(res[0]+" "+res[1]);
    }
}
