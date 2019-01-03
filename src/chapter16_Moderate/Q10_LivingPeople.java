package chapter16_Moderate;

import java.util.List;

public class Q10_LivingPeople {
    class Person{
        int birth;
        int death;
    }

    int maxAliveYear(List<Person> people, int min, int max){
        int[] population = new int[max-min+1];
        for(Person person: people){
            int birthIdx = person.birth-min;
            int deathIdx = person.death-min;
            population[birthIdx]++;
            if(deathIdx<population.length-1) population[deathIdx+1]--;
        }

        int maxAlive = population[0];
        int maxAliveYear = min;
        for(int i=1;i<population.length;i++){
            population[i] += population[i-1];
            if(population[i]>maxAlive){
                maxAlive = population[i];
                maxAliveYear = min + i;
            }
        }

        return maxAliveYear;
    }
}
