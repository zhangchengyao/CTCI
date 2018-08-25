import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    static class Edge{
        int tail;
        int head;
        int weight;

        public Edge(int tail, int head, int weight){
            this.tail = tail;
            this.head = head;
            this. weight = weight;
        }
    }
    static class Graph{
        ArrayList<Edge> edges;
        int[] shortestPath;

        public Graph(String filname, int num_vertices){
            edges = new ArrayList<>();
            shortestPath = new int[num_vertices];
            initGraph(filname);
        }
        private void initGraph(String filename){
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String line;
                while((line=br.readLine())!=null){
                    String[] items = line.split("\t");
                    int from = Integer.parseInt(items[0]);
                    int to;
                    int weight;
                    for(int i=1;i<items.length;i++){
                        String[] e = items[i].split(",");
                        to = Integer.parseInt(e[0]);
                        weight = Integer.parseInt(e[1]);
                        addEdge(from, to, weight);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        void addEdge(int from, int to, int weight){
            edges.add(new Edge(from, to, weight));
        }

        public int[] Dijkstra(){

        }
    }

    public static void main(String[] args){
        Graph graph = new Graph("dijkstraData.txt", 200);
        for(int i=0;i<12;i++){
            Edge edge = graph.edges.get(i);
            System.out.println(edge.tail+" --> "+edge.head+" Weight = "+edge.weight);
        }
    }
}
