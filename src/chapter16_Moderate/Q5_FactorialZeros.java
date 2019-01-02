package chapter16_Moderate;

public class Q5_FactorialZeros {
    int countFacZero(int n){
        int count = 0;
        for(int i=5;n/i>0;i*=5){
            count += n/i;
        }
        return count;
    }
}
