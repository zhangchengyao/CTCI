package chapter6_MathAndLogicalPuzzles;

public class Q9_100Lockers {
    // just need to count the number of perfect square
    int numOfOpenLockers(int n){
        return (int)Math.sqrt(n);
    }
//    int numOfOpenLockers(int n){
//        int[] numToggles = new int[n+1];
//        for(int i=1;i<=n;i++){
//            for(int j=i;j<=n;j+=i){
//                numToggles[j]++;
//            }
//        }
//
//        int res = 0;
//        for(int toggle: numToggles){
//            if((toggle&1)==1) res++;
//        }
//
//        return res;
//    }
}
