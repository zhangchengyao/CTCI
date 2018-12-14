package chapter1_ArraysAndStrings;

public class Q1_IsUnique {
    boolean isUniqueChars(String s){
        // assume only use lowercase characters
        int checker = 0;
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i)-'a';
            if((checker & (1<<val))!=0) return false;
            checker |= (1<<val);
        }
        return true;
    }
}
