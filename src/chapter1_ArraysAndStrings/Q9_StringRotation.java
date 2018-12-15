package chapter1_ArraysAndStrings;

public class Q9_StringRotation {
    boolean isRotation(String s1, String s2){
        if(s1.length()==0 || s1.length()!=s2.length()) return false;
        String s1s1 = s1+s1;
        return isSubstring(s2, s1s1);
    }
    private boolean isSubstring(String s, String t){
        return t.contains(s);
    }
}
