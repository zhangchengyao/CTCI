package chapter5_BitManipulation;

public class Q6_Conversion {
    int numFlips(int a, int b){
        int cnt = 0;
        for(int c=a^b;c!=0;c=c&(c-1)){
            cnt++;
        }
        return cnt;
    }
}
