package chapter17_Hard;

public class Q16_TheMasseuse {
    int maxMinutes(int[] appointments){
        int[] maxSum = new int[appointments.length];
        maxSum[0] = appointments[0];
        maxSum[1] = Math.max(appointments[0], appointments[1]);

        for(int i=2;i<appointments.length;i++){
            maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2]+appointments[i]);
        }

        return maxSum[appointments.length-1];
    }
}
