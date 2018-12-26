package chapter4_TreesAndGraphs;

public class Test {
    public static void main(String[] args){
        String[] projects = new String[]{"a","b","c","d","e","f"};
        String[][] dependencies = new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};
        Q7_BuildOrder test = new Q7_BuildOrder();
        String[] res = test.findBuildOrder(projects, dependencies);
        for(String project: res) System.out.println(project);
    }
}
