package chapter6_MathAndLogicalPuzzles;

import java.util.ArrayList;
import java.util.List;

public class Q10_Poison {
    static final int DAYS_FOR_RESULTS = 7;
    class Bottle{
        private int id;
        private boolean poison;

        Bottle(int _id, boolean _poison){
            id = _id;
            poison = _poison;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isPoison() {
            return poison;
        }

        public void setPoison(boolean poison) {
            this.poison = poison;
        }
    }

    class TestStrip{
        private int id;
        private List<List<Bottle>> testedBottles;

        TestStrip(int _id){
            id = _id;
            testedBottles = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void addDrop(Bottle bottle, int day){
            while(testedBottles.size()<=day) testedBottles.add(new ArrayList<>());
            testedBottles.get(day).add(bottle);
        }

        public boolean isPositiveOnDay(int day){
            List<Bottle> bottles = this.testedBottles.get(day-DAYS_FOR_RESULTS);
            for(Bottle bottle: bottles){
                if(bottle.isPoison()) return true;
            }
            return false;
        }
    }

    int findPoisonedBottle(List<Bottle> bottles, List<TestStrip> strips){
        for(Bottle bottle: bottles){
            int id = bottle.getId();
            int i = 0;
            while(id>0){
                if((id&1)==1) strips.get(i).addDrop(bottle, 0);
                id >>>= 1;
            }
        }

        List<Integer> positiveStrips = new ArrayList<>();
        for(TestStrip strip: strips){
            if(strip.isPositiveOnDay(7)) positiveStrips.add(strip.getId());
        }

        int id = 0;
        for(int idx: positiveStrips){
            id |= (1<<idx);
        }

        return id;
    }
}
