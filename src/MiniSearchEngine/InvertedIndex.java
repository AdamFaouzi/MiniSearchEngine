import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {
    private Map<String, Map<Document, Integer>> index = new HashMap<>();//index map with String(word) as key
                                                                        //value as Map with key as a Document
                                                                        //and value as Integer, in this case the count


    public void addDocument(Document doc, List<String> tokens){//function to add documents to the index map
        for(String token : tokens){//loop through all tokens in document
            index.putIfAbsent(token, new HashMap<>());//if the word has not been found initialise it as a key and its HashMap
            Map<Document,Integer> docFrequency = index.get(token);//docFrequency is initialised the same as index secondary level map
            docFrequency.put(doc, docFrequency.getOrDefault(doc, 0)+1);//put the frequency of the word in the doucment
                                                                                    //as either the existing value+1 or default to 0+1
        }
    }

    public Map<Document, Integer> getDocumentsForTerm(String term){//get the secondary index map either returns the 
        return index.getOrDefault(term, Collections.emptyMap());   //Map<Document,Integer> or an empty map if nothing exists
    }

    public int getUniqueTermCount(){//return the amount of words found aka number of keys
        return index.size();
    }
}
