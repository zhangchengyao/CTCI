package chapter17_Hard;

import java.util.Random;

public class Q2_Shuffle {
    void shuffleArray(int[] cards){
        Random rand = new Random();
        for(int i=0;i<cards.length;i++){
            int k = rand.nextInt(i+1);
            swap(cards, i, k);
        }
    }

    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
