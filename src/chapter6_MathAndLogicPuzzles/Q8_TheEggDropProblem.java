package chapter6_MathAndLogicPuzzles;

import java.util.Random;

public class Q8_TheEggDropProblem {
    private int numFloors;
    private int breakingPoint;
    private int countDrops;

    Q8_TheEggDropProblem(){
        numFloors = 100;
        breakingPoint = new Random().nextInt(numFloors)+1;
        countDrops = 0;
        System.out.println("Answer: "+breakingPoint);
    }

    private boolean drop(int floor){
        countDrops++;
        return floor >= breakingPoint;
    }

    int findBreakingPoint(){
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;

        while(egg1<=numFloors && !drop(egg1)){
            interval--;
            previousFloor = egg1;
            egg1 += interval;
        }

        if(egg1>numFloors) return -1;

        int egg2 = previousFloor + 1;
        while(egg2<egg1 && !drop(egg2)){
            egg2 += 1;
        }

        return egg2;
    }

    int getNumDrops(){
        return countDrops;
    }
}
