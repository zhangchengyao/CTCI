package chapter8_RecursionAndDynamicProgramming;

import java.util.Stack;

public class Q6_TowersOfHanoi {
    class Tower{
        private Stack<Integer> disks;
        private int id;

        Tower(int _id){
            disks = new Stack<>();
            id = _id;
        }

        public void add(int disk){
            if(!disks.isEmpty() && disk>=disks.peek()){
                System.out.println("Error in placing disk "+disk);
                return ;
            }
            disks.push(disk);
        }

        public void moveTopTo(Tower t){
            t.add(disks.pop());
        }

        public void moveDisks(int n, Tower to, Tower helper){
            if(n<=0) return;
            moveDisks(n-1, helper, to);
            moveTopTo(to);
            helper.moveDisks(n-1, to, this);
        }
    }

    void hanoi(){
        Tower[] towers = new Tower[3];
        for(int i=0;i<towers.length;i++) towers[i] = new Tower(i);

        int numDisks = 5;
        for(int i=numDisks;i>0;i--){
            towers[0].add(i);
        }

        towers[0].moveDisks(numDisks, towers[2], towers[1]);
    }
//    void hanoi(int n, int from, int to, int helper){
//        if(n<=0) return;
//        hanoi(n-1, from, helper, to);
//        System.out.println("Move disk "+n+" from "+from+" to "+to);
//        hanoi(n-1, helper, to, from);
//    }
}
