package chapter17_Hard;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Q19_MissingTwo test = new Q19_MissingTwo();
        int[] res = test.missingTwo(new int[]{3,5,4,6});
        for(int i: res){
            System.out.println(i);
        }
    }
}
