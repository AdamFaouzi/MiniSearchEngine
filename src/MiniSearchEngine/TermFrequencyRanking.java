import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TermFrequencyRanking implements RankingStrategy{
        @Override//overide RankingStrategy rank function
        public List<SearchResult> rank(Map<Document, Integer> score){
            List<SearchResult> results = new ArrayList<>();//create a list of results to return
            for(Map.Entry<Document, Integer> entry : score.entrySet()){//loop through scores
                results.add(new SearchResult(entry.getKey(), entry.getValue()));//add new SearchReult found into results
            }
            results.sort((a,b)->b.getScore()-a.getScore());//sort results based of scores descending order
            return results;
        }
}
