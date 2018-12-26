package chapter4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q7_BuildOrder {
    String[] findBuildOrder(String[] projects, String[][] dependencies){
        // build graph
        Project[] graph = new Project[projects.length];
        HashMap<String, Project> map = new HashMap<>();
        for(int i=0;i<projects.length;i++){
            graph[i] = new Project(projects[i]);
            map.put(projects[i], graph[i]);
        }
        for(String[] dependency: dependencies){
            String from = dependency[0];
            String to = dependency[1];
            map.get(from).children.add(map.get(to));
            map.get(to).dependency++;
        }

        // initialize order
        String[] order = new String[projects.length];
        int endOfList = 0;
        int cur = 0;
        for(Project p: graph){
            if(p.dependency==0){
                order[endOfList++] = p.name;
            }
        }

        while(endOfList<order.length){
            Project project = map.get(order[cur++]);
            if(project==null) return null;

            for(Project child: project.children){
                child.dependency--;
                if(child.dependency==0){
                    order[endOfList++] = child.name;
                }
            }
        }

        return order;
    }

    class Project{
        String name;
        int dependency;
        List<Project> children;

        Project(String _name){
            name = _name;
            dependency = 0;
            children = new ArrayList<>();
        }
    }
}
