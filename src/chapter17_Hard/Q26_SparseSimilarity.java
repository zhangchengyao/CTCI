package chapter17_Hard;

import java.util.*;

public class Q26_SparseSimilarity {
    List<DocPair> computeSimilarities(List<Document> documents){
        HashMap<Integer, Document> documentMap = generateDocumentMap(documents);
        HashMap<Integer, List<Integer>> documentGroup = groupDocuments(documents);

        HashMap<DocPair, Integer> pairs = new HashMap<>();
        for(List<Integer> list: documentGroup.values()){
            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    DocPair pair = new DocPair(list.get(i), list.get(j));
                    pairs.putIfAbsent(pair, 0);
                    pairs.put(pair, pairs.get(pair)+1);
                }
            }
        }

        return calculateSimilarity(pairs, documentMap);
    }

    private List<DocPair> calculateSimilarity(HashMap<DocPair, Integer> pairs, HashMap<Integer, Document> documentMap){
        for(Map.Entry<DocPair, Integer> entry: pairs.entrySet()){
            DocPair pair = entry.getKey();
            Document d1 = documentMap.get(pair.doc1);
            Document d2 = documentMap.get(pair.doc2);
            int intersection = entry.getValue();
            int union = d1.words.size() + d2.words.size() - intersection;
            pair.similarity = intersection / (double)union;
        }

        return new ArrayList<>(pairs.keySet());
    }

    private HashMap<Integer, Document> generateDocumentMap(List<Document> documents){
        HashMap<Integer, Document> map = new HashMap<>();
        for(Document d: documents){
            map.put(d.docId, d);
        }

        return map;
    }

    private HashMap<Integer, List<Integer>> groupDocuments(List<Document> documents){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(Document d: documents){
            for(int num: d.words){
                map.putIfAbsent(num, new ArrayList<>());
                map.get(num).add(d.docId);
            }
        }

        return map;
    }

    class DocPair{
        int doc1;
        int doc2;
        double similarity;

        DocPair(int _doc1, int _doc2){
            doc1 = _doc1;
            doc2 = _doc2;
        }

        public int hashCode(){
            return (doc1*31)^doc2;
        }

        public boolean equals(Object o){
            if(o instanceof DocPair){
                DocPair other = (DocPair)o;
                return (doc1==other.doc1 && doc2==other.doc2)
                        || (doc1==other.doc2 && doc2==other.doc1);
            }
            return false;
        }
    }

    static class Document{
        List<Integer> words;
        int docId;

        Document(List<Integer> _words, int _docId){
            words = _words;
            docId = _docId;
        }
    }
}
