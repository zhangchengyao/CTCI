package chapter5_BitManipulation;

public class Q7_PairwiseSwap {
    int swapOddEvenBits(int num){
        return ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
    }
}
