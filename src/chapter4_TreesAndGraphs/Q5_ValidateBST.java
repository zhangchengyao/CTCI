package chapter4_TreesAndGraphs;

public class Q5_ValidateBST {
    boolean checkBST(TreeNode root){
        return checkBST(root, null, null);
    }

    private boolean checkBST(TreeNode root, Integer min, Integer max){
        if(root==null) return true;

        if((min!=null && root.val<min) || (max!=null && root.val>max)){
            return false;
        }

        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}
