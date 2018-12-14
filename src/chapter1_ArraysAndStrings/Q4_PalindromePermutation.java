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
}
