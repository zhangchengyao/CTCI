package chapter17_Hard;

import chapter16_Moderate.Q23_Rand7FromRand5;

import java.util.*;

public class Test {
    public static void main(String[] args){
        List<Q26_SparseSimilarity.Document> input = new ArrayList<>();
        input.add(new Q26_SparseSimilarity.Document(Arrays.asList(14,15,100,9,3), 13));
        input.add(new Q26_SparseSimilarity.Document(Arrays.asList(32,1,5,9,3), 16));
        input.add(new Q26_SparseSimilarity.Document(Arrays.asList(15,29,2,6,8,7), 19));
        input.add(new Q26_SparseSimilarity.Document(Arrays.asList(7,10), 24));

        List<Q26_SparseSimilarity.DocPair> res = new Q26_SparseSimilarity().computeSimilarities(input);
        for(Q26_SparseSimilarity.DocPair pair: res){
            System.out.println(pair.doc1+", "+pair.doc2+" : "+pair.similarity);
        }
    }
}
