package chapter4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q9_BSTSequences {
    List<LinkedList<Integer>> allSequences(TreeNode root){
        List<LinkedList<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        List<LinkedList<Integer>> leftSeq = allSequences(root.left);
        List<LinkedList<Integer>> rightSeq = allSequences(root.right);

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);

        for(LinkedList<Integer> left: leftSeq){
            for(LinkedList<Integer> right: rightSeq){
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weave(left, right, prefix, weaved);
                res.addAll(weaved);
            }
        }
        return res;
    }
    private void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, List<LinkedList<Integer>> res){
        if(first.size()==0 || second.size()==0){
            LinkedList<Integer> list = new LinkedList<>(prefix);
            list.addAll(first);
            list.addAll(second);
            res.add(list);
            return;
        }

        int val = first.removeFirst();
        prefix.addLast(val);
        weave(first, second, prefix, res);
        prefix.removeLast();
        first.addFirst(val);

        val = second.removeFirst();
        prefix.addLast(val);
        weave(first, second, prefix, res);
        prefix.removeLast();
        second.addFirst(val);
    }
}
