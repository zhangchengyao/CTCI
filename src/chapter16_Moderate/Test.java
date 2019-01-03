package chapter16_Moderate;

public class Test {
    public static void main(String[] args){
        Q15_MasterMind test = new Q15_MasterMind();
        int[] res = test.estimate("RGGBY", "RBBBG");
        System.out.println(res[0]+" "+res[1]);
    }
}
