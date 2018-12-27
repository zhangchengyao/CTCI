package chapter4_TreesAndGraphs;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int size;

    TreeNode(int _val){
        val = _val;
        size = 1;
    }
}
