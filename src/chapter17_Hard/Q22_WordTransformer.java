package chapter17_Hard;

import java.util.*;

public class Q22_WordTransformer {
    List<String> transform(String from, String to, List<String> dictionary){
        if(from.equals(to)) return Arrays.asList(from);
        if(!dictionary.contains(to)) return null;

        HashMap<String, List<String>> graph = createGraph(dictionary);

        HashSet<String> visited = new HashSet<>();
        HashMap<String, String> last = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(from);
        while(!q.isEmpty()){
            String cur = q.poll();
            if(cur.equals(to)) break;

            if(graph.get(cur)==null || graph.get(cur).size()==0) continue;
            for(String neighbor: graph.get(cur)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    q.offer(neighbor);
                    last.put(neighbor, cur);
                }
            }
        }

        List<String> seq = new ArrayList<>();

        if(last.containsKey(to)){
            String lastStr = last.get(to);
            seq.add(0, to);
            while(!lastStr.equals(from)){
                seq.add(0, lastStr);
                lastStr = last.get(lastStr);
            }
            seq.add(0, lastStr);
        }

        return seq;
    }

    private HashMap<String, List<String>> createGraph(List<String> dictionary){
        HashMap<String, List<String>> graph = new HashMap<>();

        for(int i=0;i<dictionary.size();i++){
            String s1 = dictionary.get(i);
            for(int j=i+1;j<dictionary.size();j++){
                String s2 = dictionary.get(j);
                if(distance(s1, s2)==1){
                    graph.putIfAbsent(s1, new ArrayList<>());
                    graph.putIfAbsent(s2, new ArrayList<>());
                    graph.get(s1).add(s2);
                    graph.get(s2).add(s1);
                }
            }
        }

        return graph;
    }

    private int distance(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int dist = 0;
        for(int i=0;i<Math.min(len1, len2);i++){
            if(s1.charAt(i)!=s2.charAt(i)) dist++;
        }

        return dist + Math.abs(len1-len2);
    }
}
