package chapter17_Hard;

public class Q21_VolumeOfHistogram {
    int volumeOfHistogram(int[] hist){
        if(hist==null || hist.length<3) return 0;

        int left = 0;
        int right = hist.length-1;
        int maxVolume = 0;
        while(left<right){
            int min = Math.min(hist[left], hist[right]);
            if(min==hist[left]){
                while(hist[++left]<min){
                    maxVolume += min - hist[left];
                }
            } else {
                while(hist[--right]<min){
                    maxVolume += min - hist[right];
                }
            }
        }

        return maxVolume;
    }
}
