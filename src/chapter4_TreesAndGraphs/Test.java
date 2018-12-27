package chapter4_TreesAndGraphs;

public class Test {
    public static void main(String[] args){
        String[] projects = new String[]{"a","b","c","d","e","f"};
        String[][] dependencies = new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"},{"c","d"}};
        Q7_BuildOrder test = new Q7_BuildOrder();
        String[] res = test.findBuildOrder(projects, dependencies);
        if(res==null) System.out.println((Object) null);
        else for(String project: res) System.out.println(project);
    }
}
