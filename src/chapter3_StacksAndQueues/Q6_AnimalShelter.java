package chapter3_StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_AnimalShelter {
    class Animal{
        int order;

        Animal(int _order){
            order = _order;
        }

        boolean olderThan(Animal another){
            return this.order < another.order;
        }
    }
    class Dog extends Animal{
        Dog(int _order) { super(_order); }
    }
    class Cat extends Animal{
        Cat(int _order) { super(_order); }
    }

    private Queue<Dog> dogQueue;
    private Queue<Cat> catQueue;
    private int order;

    public Q6_AnimalShelter(){
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal){
        animal.order = order++;
        if(animal instanceof Dog) dogQueue.offer((Dog)animal);
        else catQueue.offer((Cat)animal);
    }

    public Animal dequeueAny(){
        if(!dogQueue.isEmpty() && dogQueue.peek().olderThan(catQueue.peek())) return dogQueue.poll();
        else return catQueue.poll();
    }

    public Dog dequeueDog(){
        return dogQueue.poll();
    }

    public Cat dequeueCat(){
        return catQueue.poll();
    }
}
