package chapter16_Moderate;

import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args){
        int[] a = {4,1,2,1,1,2,2};
        List<int[]> res = new Q24_PairsWithSum().pairSums(a, 6);
        for(int[] item: res){
            System.out.println(item[0]+" "+item[1]);
        }
    }
}
