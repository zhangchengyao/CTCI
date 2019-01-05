package chapter17_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args){
        HashMap<String, Integer> raw = new HashMap<>();
        raw.put("John", 15);
        raw.put("Jon", 12);
        raw.put("Chris", 13);
        raw.put("Kris", 4);
        raw.put("Christopher", 19);
        List<String[]> syn = new ArrayList<>();
        syn.add(new String[]{"Jon", "John"});
        syn.add(new String[]{"John", "Johnny"});
        syn.add(new String[]{"Chris", "Kris"});
        syn.add(new String[]{"Chris", "Christopher"});
        HashMap<String, Integer> res = new Q7_BabyNames().realNameFreq(raw, syn);
        for(Map.Entry<String, Integer> entry: res.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
