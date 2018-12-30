package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q13_StackOfBoxes {
    class Box{
        int width;
        int height;
        int depth;
        Box(){}
        Box(Box box){
            this.width = box.width;
            this.height = box.height;
            this.depth = box.depth;
        }
    }


    int heightOfTallestStack(List<Box> boxes){
        Collections.sort(boxes, (a,b)->b.width-a.width);
        int max = Integer.MIN_VALUE;
        int[] memo = new int[boxes.size()];
        for(int i=0;i<boxes.size();i++){
            int height = heightOfStackWithBottom(boxes, i, memo);
            max = Math.max(max, height);
        }
        return max;
    }

    private int heightOfStackWithBottom(List<Box> boxes, int idx, int[] memo){
        if(memo[idx]>0) return memo[idx];

        Box bottom = boxes.get(idx);
        int maxHeight = Integer.MIN_VALUE;
        for(int i=idx+1;i<boxes.size();i++){
            Box boxAbove = boxes.get(i);
            if(boxAbove.depth<bottom.depth && boxAbove.height<bottom.height){
                maxHeight = Math.max(maxHeight, heightOfStackWithBottom(boxes, i, memo));
            }
        }
        memo[idx] = maxHeight + bottom.height;
        return memo[idx];
    }
}
