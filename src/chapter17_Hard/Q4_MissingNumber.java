package chapter17_Hard;

import java.util.ArrayList;
import java.util.List;

public class Q4_MissingNumber {
    int findMissingNumber(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int number: array){
            list.add(number);
        }
        return findMissing(list, 0);
    }

    private int findMissing(List<Integer> list, int offset){
        if(offset>=Integer.BYTES*8) return 0;

        List<Integer> oneBits = new ArrayList<>();
        List<Integer> zeroBits = new ArrayList<>();

        for(int number: list){
            int bit = fetch(number, offset);
            if(bit==0) zeroBits.add(number);
            else oneBits.add(number);
        }

        if(oneBits.size()>=zeroBits.size()){
            int val = findMissing(zeroBits, offset+1);
            return val<<1;
        } else {
            int val = findMissing(oneBits, offset+1);
            return (val<<1) | 1;
        }
    }

    private int fetch(int number, int j){
        return (number>>j) & 1;
    }
}
