package chapter17_Hard;

public class Q19_MissingTwo {
    int[] missingTwo(int[] array){
        int n = array.length+2;
        int sum1 = (n+1)*n/2;
        int sum2 = squareSum(n);

        for(int num: array){
            sum1 -= num;
            sum2 -= num*num;
        }

        /*
        * x + y = sum1
        * x^2 + y^2 = sum2 */
        int a = 2;
        int b = -2 * sum1;
        int c = sum1 * sum1 - sum2;

        int[] solution = {(-b-(int)Math.sqrt(b*b-4*a*c))/(2*a), (-b+(int)Math.sqrt(b*b-4*a*c))/(2*a)};
        return solution;
    }

    private int squareSum(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += i * i;
        }
        return sum;
    }
}
