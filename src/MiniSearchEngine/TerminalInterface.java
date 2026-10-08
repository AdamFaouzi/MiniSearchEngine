import java.util.List;
import java.util.Scanner;

public class TerminalInterface {
    public static void runMenu(String path){
        SearchEngine engine = new SearchEngine();
        Scanner s = new Scanner(System.in);
        boolean indexBuilt = false;

        while(true){// loop until user chooses to exit
            System.out.println("\nMini Search Engine");
            System.out.println("1. Build index");
            System.out.println("2. Search");
            System.out.println("3. Statistics");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            String choice = s.nextLine();

            if(choice.equals("1")){
                engine.loadCorpus(path);// load documents from the specified path
                engine.buildIndex();// build the inverted index
                indexBuilt = true;// set flag to indicate index has been built
            }else if(indexBuilt){// only allow search and statistics if index has been built
                if(choice.equals("2")){
                System.out.print("Enter query: ");
                String query = s.nextLine();

                List<SearchResult> results = engine.search(query);// perform search and get results
                if(results.isEmpty()){
                    System.out.println("No results found.");// handle case where no results are found
                }else{
                    for(SearchResult result : results){// print each search result
                    System.out.println(result);
                    }
                }
            }
            else if(choice.equals("3")){
                engine.showStatistics();// display statistics about the index and corpus
            } else if(choice.equals("4")){
                break;// exit the loop and end the program
            }else{
                System.out.println("Invalid choice.");// handle invalid menu choice
            }
        }else{
            System.out.println("Index has not been built yet, try again.");// prompt user to build index before searching or viewing statistics
        }
    }
        s.close();
    }
}
