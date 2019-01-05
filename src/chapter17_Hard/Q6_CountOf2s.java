package chapter17_Hard;

public class Q6_CountOf2s {
    int num2s(int n){
        int res = 0;

        int high, low;
        int len = Integer.toString(n).length();
        int pow = 1;
        for(int i=0;i<len;i++){
            int curDigit = (n/pow) % 10;
            high = n / (pow*10);
            low = n % pow;

            if(curDigit>2) res += (high+1)*pow;
            else{
                res += high*pow;
                if(curDigit==2) res += low + 1;
            }

            pow *= 10;
        }

        return res;
    }
}
