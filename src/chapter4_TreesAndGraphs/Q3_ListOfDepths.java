package chapter4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3_ListOfDepths {
    List<LinkedList<TreeNode>> createListByLevel(TreeNode root){
        List<LinkedList<TreeNode>> res = new ArrayList<>();
        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> prev;
        cur.add(root);
        while(cur.size()>0){
            res.add(cur);
            prev = cur;
            cur = new LinkedList<>();
            for(TreeNode node: prev){
                if(node.left!=null) cur.add(node.left);
                if(node.right!=null) cur.add(node.right);
            }
        }
        return res;
    }
}
