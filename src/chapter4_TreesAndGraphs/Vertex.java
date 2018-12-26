package chapter4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    int val;
    List<Vertex> edges;

    Vertex(int _val){
        val = _val;
        edges = new ArrayList<>();
    }
}
