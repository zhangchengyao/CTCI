package chapter4_TreesAndGraphs;

public class Q6_Successor {
    TreeNode getSuccessor(TreeNode node){
        if(node==null) return null;

        if(node.right!=null){
            TreeNode succ = node.right;
            while(succ.left!=null) succ = succ.left;
            return succ;
        } else{
            TreeNode succ = node.parent;
            while(succ!=null && succ.val<=node.val) succ = succ.parent;
            return succ;
        }
    }
}
