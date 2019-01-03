package chapter16_Moderate;

public class Q17_ContiguousSequence {
    int maxSum(int[] a){
        if(a==null || a.length==0) return 0;

        int maxSum = 0;
        int curSum = 0;
        for(int i=0;i<a.length;i++){
            if(curSum+a[i]>a[i]) curSum += a[i];
            else curSum = a[i];

            if(curSum>maxSum) maxSum = curSum;
        }

        return maxSum;
    }
}
