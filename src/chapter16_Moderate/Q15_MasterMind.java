package chapter16_Moderate;

import java.util.HashMap;

public class Q15_MasterMind {
    int[] estimate(String guess, String solution){
        if(solution==null || solution.equals("") || guess.length()!=solution.length()) return null;

        HashMap<Character, Integer> freqTable = buildFreqTable(solution);

        int hit = 0;
        int total = 0;
        for(int i=0;i<guess.length();i++){
            char c = guess.charAt(i);
            if(c==solution.charAt(i)) hit++;
            if(freqTable.containsKey(c) && freqTable.get(c)>0){
                total++;
                freqTable.put(c, freqTable.get(c)-1);
            }
        }

        return new int[]{hit, total-hit};
    }

    private HashMap<Character, Integer> buildFreqTable(String solution){
        HashMap<Character, Integer> freqTable = new HashMap<>();
        for(char c: solution.toCharArray()){
            freqTable.put(c, freqTable.getOrDefault(c, 0)+1);
        }
        return freqTable;
    }
}
