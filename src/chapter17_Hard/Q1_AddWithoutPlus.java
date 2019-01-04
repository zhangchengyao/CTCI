package chapter17_Hard;

public class Q1_AddWithoutPlus {
    int add(int a, int b){
        if(b==0) return a;
        if(a==0) return b;

        int sum = a ^ b;
        int carry = (a & b) << 1;

        return sum+carry;
    }
//    int add(int a, int b){
//        int res = 0;
//        int carry = 0;
//
//        for(int i=0;i<Integer.BYTES*8;i++){
//            int bita = (a>>i) & 1;
//            int bitb = (b>>i) & 1;
//
//            int mask = bita ^ bitb ^ carry;
//            carry = carry==0? bita & bitb: bita | bitb;
//
//            res |= (1&mask) << i;
//        }
//
//        return res;
//    }
}
