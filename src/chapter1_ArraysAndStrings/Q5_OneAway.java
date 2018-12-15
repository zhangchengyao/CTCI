package chapter1_ArraysAndStrings;

public class Q5_OneAway {
    boolean oneEditAway(String s1, String s2){
        if(s1.equals(s2)) return true;
        if(Math.abs(s1.length()-s2.length())>1) return false;
        // make sure s1 is shorter than or equal to s2
        if(s1.length()>s2.length()){
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.length()==s2.length()){
                    return s1.substring(i+1).equals(s2.substring(i+1));
                }else{
                    return s1.substring(i).equals(s2.substring(i+1));
                }
            }
        }
        return true;
    }
}
