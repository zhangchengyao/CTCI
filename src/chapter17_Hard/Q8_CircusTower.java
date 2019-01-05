package chapter17_Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q8_CircusTower {
    class Person{
        int height;
        int weight;

        boolean isBefore(Person p){
            return this.height<=p.height && this.weight<=p.weight;
        }
    }

    List<Person> maxNumberOfPeople(List<Person> people){
        Collections.sort(people, (a,b)->a.height-b.height);

        List<List<Person>> seqs = new ArrayList<>();
        List<Person> res = new ArrayList<>();

        for(int i=0;i<people.size();i++){
            List<Person> bestAtI = new ArrayList<>();
            for(List<Person> seq: seqs){
                if(canAppend(seq, people.get(i))){
                    if(seq.size()>bestAtI.size()) bestAtI = seq;
                }
            }

            seqs.add(new ArrayList<>(bestAtI));
            seqs.get(seqs.size()-1).add(people.get(i));
        }

        for(List<Person> seq: seqs){
            if(seq.size()>res.size()) res = seq;
        }
        return res;
    }

    private boolean canAppend(List<Person> seq, Person p){
        if(seq.size()==0) return true;

        Person last = seq.get(seq.size()-1);
        return last.isBefore(p);
    }
}
