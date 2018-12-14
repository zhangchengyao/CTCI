package chapter1_ArraysAndStrings;

public class Q2_IsPermutation {
    boolean permutation(String s, String t){
        if(s.length()!=t.length()) return false;

        int[] letters = new int[256];

        for(int i=0;i<s.length();i++){
            letters[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            letters[t.charAt(i)]--;
            if(letters[t.charAt(i)]<0) return false;
        }
        return true;
    }
}
