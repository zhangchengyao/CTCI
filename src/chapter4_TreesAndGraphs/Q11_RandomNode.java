package chapter4_TreesAndGraphs;

import java.util.Random;

public class Q11_RandomNode {
    private TreeNode root;

    TreeNode getRandomNode(){
        if(root==null) return null;
        Random rand = new Random();
        int idx = rand.nextInt(root.size);
        return getIthNode(root, idx);
    }

    private TreeNode getIthNode(TreeNode root, int i){
        if(root==null) return null;

        int leftSize = root.left==null?0:root.left.size;
        if(i==leftSize) return root;
        else if(i<leftSize) return getIthNode(root.left, i);
        else return getIthNode(root.right, i-leftSize-1);
    }
}
