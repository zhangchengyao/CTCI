package chapter4_TreesAndGraphs;

import java.util.HashMap;

public class Q12_PathsWithSum {
    int pathSum(TreeNode root, int target){
        return countPathSum(root, target, 0, new HashMap<>());
    }
    private int countPathSum(TreeNode root, int target, int runningSum, HashMap<Integer, Integer> map){
        if(root==null) return 0;

        runningSum += root.val;
        int sum = runningSum - target;
        int pathCount = map.getOrDefault(sum, 0);

        if(runningSum==target) pathCount++;

        map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        pathCount += countPathSum(root.left, target, runningSum, map);
        pathCount += countPathSum(root.right, target, runningSum, map);
        map.put(runningSum, map.getOrDefault(runningSum, 0)-1);
        if(map.get(runningSum)==0) map.remove(runningSum);

        return pathCount;
    }
}
