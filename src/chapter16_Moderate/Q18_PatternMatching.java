package chapter16_Moderate;

public class Q18_PatternMatching {
    boolean patternMatch(String value, String pattern){
        if(pattern==null || value==null || pattern.length()>value.length()) return false;

        char first = pattern.charAt(0);
        char second = first=='a'?'b':'a';

        int numFirst = countChar(pattern, first);
        int numSecond = pattern.length()-numFirst;


        for(int i=1;i<=value.length();i++){
            if(numFirst*i>value.length()) break;

            String strForFirst = value.substring(0, i);

            int lengthRemain = value.length()-numFirst*i;
            if(numSecond==0 || lengthRemain%numSecond==0){
                int firstIdxForSecond = pattern.indexOf(second)*i;
                int lenSecond = numSecond==0?0:lengthRemain/numSecond;
                String strForSecond = value.substring(firstIdxForSecond, firstIdxForSecond+lenSecond);
                if(match(value, pattern, strForFirst, strForSecond)){
                    System.out.println(strForFirst);
                    return true;
                }
            }
        }
        return false;
    }

    private int countChar(String pattern, char c){
        int count = 0;
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)==c) count++;
        }
        return count;
    }

    private boolean match(String value, String pattern, String first, String second){
        int idx = 0;
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(c==pattern.charAt(0)){
                if(!first.equals(value.substring(idx, idx+first.length()))) return false;
                idx += first.length();
            } else {
                if(!second.equals(value.substring(idx, idx+second.length()))) return false;
                idx += second.length();
            }
        }
        return true;
    }
}
