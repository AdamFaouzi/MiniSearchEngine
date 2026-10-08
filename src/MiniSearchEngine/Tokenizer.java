import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public List<String> tokenize(String text){// Convert text to lowercase and remove punctuation
        List<String> tokens = new ArrayList<>();

        text = text.toLowerCase();// Convert text to lowercase
        text = text.replaceAll("[^a-z0-9 ]", " ");// Remove punctuation

        String[]words = text.split("\\s+");// Split text into words based on whitespace

        for(String word : words){// Add non-empty words to the tokens list
            if(!word.isEmpty()){
                tokens.add(word);
            }
        }
        return tokens;
    }
}
