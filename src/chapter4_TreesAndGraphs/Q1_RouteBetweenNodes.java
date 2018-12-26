package chapter4_TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_RouteBetweenNodes {
    public boolean connected(Vertex[] graph, Vertex src, Vertex dest){
        if(src==dest) return true;

        Queue<Vertex> q = new LinkedList<>();
        HashSet<Vertex> visited = new HashSet<>();

        q.offer(src);
        visited.add(src);

        while(!q.isEmpty()){
            Vertex cur = q.poll();
            for(Vertex v: cur.edges){
                if(v==dest) return true;
                if(!visited.contains(v)){
                    visited.add(v);
                    q.offer(v);
                }
            }
        }
        return false;
    }
}
