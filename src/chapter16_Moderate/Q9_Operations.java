package chapter16_Moderate;

public class Q9_Operations {
    int subtract(int a, int b){
        return a + negate(b);
    }

    int multiply(int a, int b){
        if(a<b) return multiply(b, a);

        int sum = 0;
        for(int i=0;i<Math.abs(b);i++){
            sum += a;
        }

        if(b<0) sum = negate(sum);

        return sum;
    }

    int divide(int a, int b){
        if(b==0) throw new ArithmeticException();
        if(a==0) return 0;

        int absa = Math.abs(a);
        int absb = Math.abs(b);

        int res = 0;
        int sum = 0;
        while(sum+absb<=absa){
            res++;
            sum += absb;
        }

        if((a>0)!=(b>0)) res = negate(res);

        return res;
    }

    private int negate(int x){
        int res = 0;
        int newSign = x<0?1:-1;
        int delta = newSign;
        while(x!=0){
            boolean signChange = (x+delta>0) != (x>0);
            if(x+delta!=0 && signChange) delta = newSign;
            x += delta;
            res += delta;
            delta += delta;
        }
        return res;
    }
}
