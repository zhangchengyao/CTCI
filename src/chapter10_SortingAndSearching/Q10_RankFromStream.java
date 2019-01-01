package chapter10_SortingAndSearching;

import java.util.Map;
import java.util.TreeMap;

public class Q10_RankFromStream {
    class TreeNode{
        int size;
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int _val){
            size = 1;
            val = _val;
        }

        void insert(int x){
            size++;
            if(x<=val){
                if(left==null) left = new TreeNode(x);
                else left.insert(x);
            } else {
                if(right==null) right = new TreeNode(x);
                else right.insert(x);
            }
        }

        int getRank(int x){
            if(x==val){
                return left==null?0:left.size;
            } else if(x<val){
                if(left==null) return -1;
                return left.getRank(x);
            } else {
                if(right==null) return -1;
                return (left==null?0:left.size) + 1 + right.getRank(x);
            }
        }
    }

    private TreeNode root;

    void track(int x){
        if(root==null) root = new TreeNode(x);
        else root.insert(x);
    }

    int getRankOfNumber(int x){
        if(root==null) return -1;
        return root.getRank(x);
    }
//    TreeMap<Integer, Integer> ranks;
//
//    Q10_RankFromStream(){
//        ranks = new TreeMap<>();
//    }
//
//    void track(int x){
//        Map<Integer, Integer> subMap = ranks.tailMap(x, true);
//        for(Integer k: subMap.keySet()){
//            ranks.put(k, ranks.get(k)+1);
//        }
//        ranks.putIfAbsent(x, ranks.headMap(x, false).size());
//    }
//
//    int getRankOfNumber(int x){
//        return ranks.get(x);
//    }
}
