package chapter5_BitManipulation;

public class Q3_FlipBitToWin {
    int longestSeqOf1s(int num){
        if(~num == 0) return Integer.BYTES * 8;

        int curLen = 0;
        int prevLen = 0;
        int maxLen = 1;
        while(num>0){
            if((num&1)==1){
                curLen++;
            } else {
                prevLen = (num&2)==0?0:curLen;
                curLen = 0;
            }
            maxLen = Math.max(maxLen, curLen+prevLen+1);
            num >>>= 1;
        }
        return maxLen;
    }
}
