package chapter16_Moderate;

public class Q7_NumberMax {
    int getMax(int a, int b){
        // when a and b have different signs, maybe overflow
        int c = a-b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        /* if a and b have different signs
         * a-b has the same sign with a
         * */
        int useSignA = sa ^ sb;
        int useSignC = flip(useSignA);

        int k = useSignA * sa + useSignC * sc;
        int q = flip(k);

        return a * k + b * q;
    }

    /* if x>=0, return 1, if x<0 return 0 */
    private int sign(int x){
        return flip((x>>31) & 1);
    }

    private int flip(int bit){
        return 1^bit;
    }
}
