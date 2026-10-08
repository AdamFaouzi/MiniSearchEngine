import java.util.List;

public class QueryParser {//class to parse the query and return a list of tokens
    private Tokenizer tokenizer;

    public QueryParser(){
        tokenizer = new Tokenizer();
    }

    public List<String> parse(String query){
        return tokenizer.tokenize(query);
    }
}
