package chapter8_RecursionAndDynamicProgramming;

public class Q5_RecursiveMultiply {
//    int multiply(int a, int b){
//        int res = 0;
//        int offset = 0;
//        while(b!=0){
//            if((b&1)==1) res += a << offset;
//            offset++;
//            b >>>= 1;
//        }
//        return res;
//    }
    int multiply(int a, int b){
        int smaller = a<b?a:b;
        int bigger = a<b?b:a;

        return multiplyHelper(smaller, bigger);
    }
    private int multiplyHelper(int smaller, int bigger){
        if(smaller==0) return 0;
        else if(smaller==1) return bigger;

        int half = smaller >> 1;
        int halfProduct = multiplyHelper(half, bigger);

        int res = halfProduct << 1;
        if((smaller&1)==1) res += bigger;

        return res;
    }
}
