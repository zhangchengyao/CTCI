package chapter10_SortingAndSearching;

public class Test {
    public static void main(String[] args){
        Q10_RankFromStream test = new Q10_RankFromStream();
        test.track(5);
        test.track(1);
        System.out.println(test.getRankOfNumber(5));;
        System.out.println(test.getRankOfNumber(1));;
        test.track(4);
        test.track(4);
        System.out.println(test.getRankOfNumber(4));;
    }
}
