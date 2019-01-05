package chapter17_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q11_WordDistance {
    private HashMap<String, List<Integer>> locations = null;

    int minDistance(String[] file, String word1, String word2){
        if(locations==null) initLocations(file);

        return minDistance(word1, word2);
    }

    private int minDistance(String word1, String word2){
        List<Integer> locations1 = locations.get(word1);
        List<Integer> locations2 = locations.get(word2);

        if(locations1==null || locations2==null || locations1.size()==0 || locations2.size()==0) return -1;

        int idx1 = 0;
        int idx2 = 0;
        int min = Integer.MAX_VALUE;
        while(idx1<locations1.size() && idx2<locations2.size()){
            int dist = Math.abs(locations1.get(idx1)-locations2.get(idx2));
            if(dist<min) min = dist;
            if(min==1) return min;
            if(locations1.get(idx1)<locations2.get(idx2)) idx1++;
            else idx2++;
        }

        return min;
    }

    private void initLocations(String[] file){
        locations = new HashMap<>();
        for(int i=0;i<file.length;i++){
            String str = file[i];
            locations.putIfAbsent(str, new ArrayList<>());
            locations.get(str).add(i);
        }
    }
}
