package chapter17_Hard;

import java.util.*;

public class Test {
    public static void main(String[] args){
        int[] shorter = {1,5,9};
        int[] longer= {7,1,5,9};//{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] res = new Q18_ShortestSupersequence().shortestSupersequence(shorter, longer);
        System.out.println(res[0]+" "+res[1]);
    }
}
