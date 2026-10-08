import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchEngine {
    private Corpus corpus;
    private InvertedIndex index;
    private Tokenizer tokenizer;
    private RankingStrategy rankingStrategy = new TermFrequencyRanking();

    public SearchEngine(){
        corpus = new Corpus();
        index = new InvertedIndex();
        tokenizer = new Tokenizer();
    }

    public List<SearchResult> search(String query){//search for a query and return ranked results
        QueryParser parser = new QueryParser();
        List<String> terms = parser.parse(query);//parse the query into terms

        Map<Document,Integer> scores = new HashMap<>();

        for(String term : terms){//for each term in the query, get the documents that contain it and update their scores
            Map<Document,Integer> docs = index.getDocumentsForTerm(term);

            for(Document doc : docs.keySet()){//for each document that contains the term, update its score based on the term frequency
                int frequency = docs.get(doc);
                scores.put(doc, scores.getOrDefault(doc, 0)+frequency);
            }
        }

        return rankingStrategy.rank(scores);
    }

    void loadCorpus(String folderPath){//load documents from a folder into the corpus
        corpus.loadFromFolder(folderPath);
    }

    void buildIndex(){//build the inverted index from the documents in the corpus
        for (Document doc : corpus.getDocuments()){//for each document in the corpus, tokenize its content and add it to the index
            List<String> tokens = tokenizer.tokenize(doc.getContent());
            index.addDocument(doc, tokens);//add the document and its tokens to the index
        }
        System.out.println("Index built succesfully.");//print a message that the index has been built
    }

    public void showStatistics(){//show statistics about the corpus and the index
        if(corpus==null){
            System.out.println("No corpus loaded.");
            return;
        }
        System.out.println("Number of documents: " + corpus.getDocuments().size());//print the number of documents in the corpus
        System.out.println("Number of unique terms: " + index.getUniqueTermCount());//print the number of unique terms in the index
    }

}
