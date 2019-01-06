package chapter17_Hard;

import java.util.*;

public class Test {
    public static void main(String[] args){
        String[] T = {"i","is","pp","ms"};
        HashMap<String, List<Integer>> res = new Q17_MultiSearch().searchAll("mississippi", T);
        for(Map.Entry<String, List<Integer>> entry: res.entrySet()){
            System.out.print(entry.getKey()+": ");
            System.out.println(entry.getValue());
        }
    }
}
