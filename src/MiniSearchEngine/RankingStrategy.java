import java.util.List;
import java.util.Map;

public interface RankingStrategy {
    List<SearchResult> rank(Map<Document, Integer> scores);
}