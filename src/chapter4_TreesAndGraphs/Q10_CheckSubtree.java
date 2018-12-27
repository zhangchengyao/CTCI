package chapter4_TreesAndGraphs;

public class Q10_CheckSubtree {
    boolean isSubtree(TreeNode t1, TreeNode t2){
        if(t2==null) return true;
        if(t1==null) return false;

        if(t1.val==t2.val && match(t1, t2)) return true;
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    private boolean match(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        else if(t1==null || t2==null) return false;
        else return t1.val==t2.val && match(t1.left, t2.left) && match(t1.right, t2.right);
    }
}
