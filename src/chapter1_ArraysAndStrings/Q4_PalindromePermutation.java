package chapter1_ArraysAndStrings;

public class Q4_PalindromePermutation {
    boolean isPermutationOfPalindrome(String s){
        int[] freqTable = new int[26];
        boolean foundOdd = false;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            freqTable[idx]++;
        }
        for(int freq: freqTable){
            if((freq&1) == 1){
                if(foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }
    // use bit manipulation
    // an integer x has exactly one 1, then x & (x-1) is 0
//    boolean isPermutationOfPalindrome(String s){
//        int bitVector = createBitVector(s);
//        return bitVector == 0 || (bitVector & (bitVector-1)) == 0;
//    }
//    private int createBitVector(String s){
//        int bitVector = 0;
//        for(int i=0;i<s.length();i++){
//            int val = s.charAt(i)-'a';
//            int mask = 1<<val;
//            if((bitVector&mask)==0){
//                bitVector |= mask;
//            }else{
//                bitVector &= ~mask;
//            }
//        }
//        return bitVector;
//    }
}
