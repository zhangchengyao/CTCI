package chapter10_SortingAndSearching;

public class Q8_FindDuplicates {
    void findDuplicates(int[] arr){
        byte[] bitVector = new byte[arr.length/8+1];

        for(int i: arr){
            if(!setBitVector(bitVector, i)) System.out.println(i);
        }
    }

    private boolean setBitVector(byte[] bitVector, int val){
        int mask = 1 << (val%8);
        if((bitVector[val/8] & mask) ==0){
            bitVector[val/8] |= mask;
            return true;
        } else {
            return false;
        }
    }
}
