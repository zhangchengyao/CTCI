package chapter17_Hard;

public class Q9_KthMultiple {
    int kthMultiple(int k){
        if(k==1) return 1;

        int[] nums = new int[k];
        nums[0] = 1;
        int mul3 = 0;
        int mul5 = 0;
        int mul7 = 0;
        for(int i=1;i<k;i++){
            int val3 = nums[mul3] * 3;
            int val5 = nums[mul5] * 5;
            int val7 = nums[mul7] * 7;

            int min = Math.min(Math.min(val3, val5), val7);
            nums[i] = min;

            if(min==val3) mul3++;
            if(min==val5) mul5++;
            if(min==val7) mul7++;
        }

        return nums[k-1];
    }
}
