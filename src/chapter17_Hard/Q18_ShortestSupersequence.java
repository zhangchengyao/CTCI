package chapter17_Hard;

import java.util.Arrays;
import java.util.HashSet;

public class Q18_ShortestSupersequence {
    int[] shortestSupersequence(int[] shorter, int[] longer){
        HashSet<Integer> set = new HashSet<>();
        for(int num: shorter) set.add(num);

        HashSet<Integer> seen = new HashSet<>();
        int minLeft = 0;
        int minLen = longer.length;
        int left = 0;
        int right = 0;
        while(right<longer.length){
            if(set.contains(longer[right])){
                set.remove(longer[right]);
                seen.add(longer[right]);
            } else if(seen.contains(longer[right])){
                while(longer[left]==longer[right] || (!seen.contains(longer[left]) && !set.contains(longer[left]))){
                    left++;
                }
            }
            if(set.size()==0){
                while(!seen.contains(longer[left])){
                    left++;
                }
                if(right-left+1<minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
            }

            right++;
        }

        return new int[]{minLeft, minLeft+minLen-1};
    }
}
