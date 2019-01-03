package chapter16_Moderate;

public class Q16_SubSort {
    int[] subsort(int[] a){
        int leftEnd = 0;
        while(leftEnd<a.length-1 && a[leftEnd]<=a[leftEnd+1]) leftEnd++;
        int rightStart = a.length-1;
        while(rightStart>0 && a[rightStart]>=a[rightStart-1]) rightStart--;

        if(leftEnd==a.length-1) return new int[]{-1, -1};

        int min = Integer.MAX_VALUE;
        for(int i=leftEnd+1;i<=rightStart;i++){
            min = Math.min(min, a[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=leftEnd;i<rightStart;i++){
            max = Math.max(max, a[i]);
        }

        while(leftEnd>=0 && a[leftEnd]>min) leftEnd--;
        while(rightStart<a.length && a[rightStart]<max) rightStart++;

        return new int[]{leftEnd+1, rightStart-1};
    }
}
