package chapter16_Moderate;

import java.util.HashSet;

public class Test {
    public static void main(String[] args){
        HashSet<String> dic = new HashSet<>();
        dic.add("tree");
        dic.add("egg");
        dic.add("used");
        dic.add("sad");
        dic.add("rad");
        Q20_T9 test = new Q20_T9();
        System.out.println(test.getWords("8733", dic));
        System.out.println(test.getWords("723", dic));
    }
}
