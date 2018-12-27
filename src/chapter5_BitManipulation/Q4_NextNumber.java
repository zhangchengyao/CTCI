package chapter5_BitManipulation;

public class Q4_NextNumber {
    int getNext(int num){
        int n = num;
        int c0 = 0;
        int c1 = 0;
        while((n&1)==0 && n!=0){
            c0++;
            n >>>= 1;
        }
        while((n&1)==1){
            c1++;
            n >>>= 1;
        }

        int mask = 1 << (c0+c1);
        num |= mask;

        mask = -mask;
        num &= mask;

        mask = (1 << (c1-1))-1;
        num |= mask;

        return num;
    }
}
