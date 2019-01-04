package chapter16_Moderate;

import java.util.Random;

public class Q23_Rand7FromRand5 {
    int rand5(){
        return new Random().nextInt(5);
    }

    int rand7(){
        while(true){
            int num = 5 * rand5() + rand5();
            if(num<21){
                return num % 7;
            }
        }
    }
}
