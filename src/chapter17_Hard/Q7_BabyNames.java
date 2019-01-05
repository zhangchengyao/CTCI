package chapter17_Hard;

import java.util.HashMap;
import java.util.List;

public class Q7_BabyNames {
    HashMap<String, Integer> realNameFreq(HashMap<String, Integer> rawData, List<String[]> synonyms){
        HashMap<String, String> parent = new HashMap<>();
        for(String key: rawData.keySet()){
            parent.put(key, key);
        }
        for(String[] synonym: synonyms){
            String name1 = synonym[0];
            String name2 = synonym[1];
            union(parent, name1, name2);
        }

        HashMap<String, Integer> res = new HashMap<>();
        for(String key: rawData.keySet()){
            String realName = find(parent, key);
            res.putIfAbsent(realName, 0);
            res.put(realName, res.get(realName)+rawData.get(key));
        }

        return res;
    }

    private String find(HashMap<String, String> parent, String name){
        while(!name.equals(parent.get(name))){
            name = parent.get(name);
        }
        return name;
    }

    private void union(HashMap<String, String> parent, String name1, String name2){
        String root1 = find(parent, name1);
        String root2 = find(parent, name2);
        if(root1.equals(root2)) return ;
        parent.put(root2, root1);
    }
}
