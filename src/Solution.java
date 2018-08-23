import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    static class Graph{
        ArrayList<ArrayList<Integer>> edges;
        ArrayList<ArrayList<Integer>> reversed_edges;
        ArrayList<Boolean> status;
        int[] finishing_time;
        int[] leader;
        int t = 0;
        int leader = -1;

        public Graph(String filename, int num_vertices){
            edges = new ArrayList<>(num_vertices);
            reversed_edges = new ArrayList<>(num_vertices);
            status = new ArrayList<>(num_vertices);
            for(int i=0;i<num_vertices;i++){
                edges.add(new ArrayList<>());
                reversed_edges.add(new ArrayList<>());
                status.add(false);
            }
            finishing_time = new int[num_vertices];
            leader = new int[num_vertices];
            initGraph(filename);
        }
        private void initGraph(String filename){
            String line;
            int from, to;
            try{
                BufferedReader br = new BufferedReader(new FileReader(filename));
                while((line=br.readLine())!=null){
                    String[] items = line.trim().split(" ");
                    from = Integer.parseInt(items[0]);
                    to = Integer.parseInt(items[1]);
                    edges.get(from-1).add(to);
                    reversed_edges.get(to-1).add(from);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        private void DFS(int startNode, boolean reverse){
            Stack<Integer> stack = new Stack<>();
            stack.push(startNode);
            while(!stack.isEmpty()){
                int cur = stack.peek();
                status.set(cur-1, true);
                ArrayList<Integer> adjs;
                if(!reverse){
                    adjs = edges.get(cur-1);
                }else{
                    adjs = reversed_edges.get(cur-1);
                }
                for (Integer adj : adjs) {
                    if (!status.get(adj - 1)) {
                        stack.push(adj);
                    }
                }
                if(cur==stack.peek()){
                    stack.pop();
                }
            }
            status.set(startNode-1, true);

        }
    }

    public static void main(String[] args){
        Graph graph = new Graph("SCC.txt", 875714);
        ArrayList<Integer> v = graph.edges.get(2);
        for(Integer item:v){
            System.out.print(item+" ");
        }
    }
}
