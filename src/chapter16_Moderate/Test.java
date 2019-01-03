package chapter16_Moderate;

public class Test {
    public static void main(String[] args){
        int[] a = {1,2,4,6,10,11};
        int[] res = new Q16_SubSort().subsort(a);
        System.out.println(res[0]+" "+res[1]);
    }
}
