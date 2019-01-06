package chapter17_Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q14_SmallestK {
    List<Integer> findSmallestKs(int[] array, int k){
        int pivot = findKthElement(array, 0, array.length-1, k);
        List<Integer> res = new ArrayList<>();

        int cnt = 0;

        for(int num: array){
            if(num<pivot) res.add(num);
        }

        while(res.size()<k){
            res.add(pivot);
        }

        return res;
    }

    private int findKthElement(int[] array, int start, int end, int k){
        int pivot = getPivot(array, start, end);
        Result result = partition(array, start, end, pivot);

        if(k<=result.leftSize){
            return findKthElement(array, start, start+result.leftSize-1, k);
        } else if(k<=result.leftSize+result.middleSize){
            return pivot;
        } else {
            return findKthElement(array, start+result.leftSize+result.middleSize, end, k-result.leftSize-result.middleSize);
        }
    }

    private int getPivot(int[] array, int start, int end){
        Random rand = new Random();
        int offset = rand.nextInt(end-start+1);
        return array[start+offset];
    }

    private Result partition(int[] array, int start, int end, int pivot){
        int left = start;
        int middle = start;
        int right = end;
        while(middle<=right){
            if(array[middle]<pivot){
                swap(array, left, middle);
                left++;
                middle++;
            } else if(array[middle]>pivot){
                swap(array, middle, right);
                right--;
            } else {
                middle++;
            }
        }
        return new Result(left-start, middle-left);
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    class Result{
        int leftSize;
        int middleSize;
        Result(int left, int middle){
            leftSize = left;
            middleSize = middle;
        }
    }
}
