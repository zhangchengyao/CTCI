package chapter17_Hard;

public class Q12_BiNode {
    static class BiNode{
        int val;
        BiNode node1; // left or prev
        BiNode node2; // right or next

        BiNode(int _val){
            val = _val;
        }
    }

    BiNode convert(BiNode root){
        return convertRec(root)[0];
    }

    private BiNode[] convertRec(BiNode root){
        if(root==null) return null;

        BiNode[] left = convertRec(root.node1);
        BiNode[] right = convertRec(root.node2);

        BiNode[] res = new BiNode[2];
        res[0] = left==null?root:left[0];
        res[1] = right==null?root:right[1];

        if(left!=null){
            left[1].node2 = root;
            root.node1 = left[1];
        }
        if(right!=null){
            root.node2 = right[0];
            right[0].node1 = root;
        }

        return res;
    }
}
