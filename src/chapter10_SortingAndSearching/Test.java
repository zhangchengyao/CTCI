package chapter10_SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        Q11_PeeksAndValleys test = new Q11_PeeksAndValleys();
        int[] a = {5,3,1,2,3};
        test.sortValleyPeek(a);
        for(int i: a) System.out.println(i);
    }
}
