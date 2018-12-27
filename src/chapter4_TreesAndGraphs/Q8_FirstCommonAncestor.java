package chapter4_TreesAndGraphs;

public class Q8_FirstCommonAncestor {
    // with links to parents
    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(!cover(root, p) || !cover(root, q)) return null;
        else if(cover(p, q)) return p;
        else if(cover(q, p)) return q;

        TreeNode parent = p.parent;
        TreeNode sibling = getSibling(p);
        while(!cover(sibling, q)){
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }
    private boolean cover(TreeNode root, TreeNode node){
        if(root==null) return false;
        if(root==node) return true;
        return cover(root.left, node) || cover(root.right, node);
    }
    private TreeNode getSibling(TreeNode node){
        if(node==null || node.parent==null) return null;
        TreeNode parent = node.parent;
        return parent.left==node?parent.right:parent.left;
    }

    // without links to parents
    TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(root==p && root==q) return root;

        TreeNode x = commonAncestor2(root.left, p, q);
        if(x!=null && x!=p && x!=q) return x;

        TreeNode y = commonAncestor2(root.right, p, q);
        if(y!=null && y!=p && y!=q) return y;

        if(x!=null && y!=null) return root;
        else if(x!=null || y!=null){
            if(root==p || root==q) return root;
            else return null;
        }
        else return null;
    }
}
