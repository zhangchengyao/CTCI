package chapter1_ArraysAndStrings;

public class Q6_StringCompression {
    String compress(String s){
        StringBuilder compressed = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int j = i+1;
            while(j<s.length() && s.charAt(i)==s.charAt(j)) j++;
            compressed.append(s.charAt(i)).append(String.valueOf(j-i));
            i = j-1;
        }
        return compressed.length()<s.length()?compressed.toString():s;
    }
}
