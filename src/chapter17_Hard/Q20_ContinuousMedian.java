package chapter17_Hard;

import java.util.PriorityQueue;

public class Q20_ContinuousMedian {
    private PriorityQueue<Integer> maxHeap; // smaller elements
    private PriorityQueue<Integer> minHeap; // bigger elements

    Q20_ContinuousMedian(){
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>();
    }

    void insert(int x){
        if(maxHeap.size()==0) maxHeap.offer(x);
        else if(maxHeap.size()==minHeap.size()){
            // should be inserted into maxHeap
            if(x>minHeap.peek()){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(x);
            } else {
                maxHeap.offer(x);
            }
        } else {
            // should be inserted into minHeap
            if(x<maxHeap.peek()){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }
        }
    }

    double getMedian(){
        if(maxHeap.size()==0){
            return Double.MIN_VALUE;
        }

        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
