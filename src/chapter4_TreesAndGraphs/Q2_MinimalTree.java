package chapter4_TreesAndGraphs;

public class Q2_MinimalTree {
    public TreeNode createMinBST(int[] array){
        return helper(array, 0, array.length-1);
    }
    private TreeNode helper(int[] array, int left, int right){
        if(left>right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(array, left, mid-1);
        root.right = helper(array, mid+1, right);
        return root;
    }
}
