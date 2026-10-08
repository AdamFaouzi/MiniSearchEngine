import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Corpus {//define Corpus class
    private List<Document> documents;//holds attrivute documents which is a list of documents
    
    public Corpus(){
        documents = new ArrayList<>();
    }

    public void loadFromFolder(String folderPath){//loadFromFolder function taking path as argument
        File folder = new File(folderPath);

        if(!folder.exists() || !folder.isDirectory()){ //checking if the folder exists
            System.out.println("Invalid folder path.");
            return;
        }

        File files[] = folder.listFiles();//storing all foles in the folder in a array of type File

        if(files == null){  //check if the files array is empty then we tell the user that the folder was empty
            System.out.println("No files found.");
            return;
        }

        int id = 1;//file id which auto increments

        for(File file : files){//loop through all the files found
            if(file.isFile() && file.getName().endsWith(".txt")){//condition to check if file is .txt file
                Document doc = new Document(id, file.getName(), file.getAbsolutePath());
                documents.add(doc);
                id++;
            }
        }
    }

    public List<Document> getDocuments(){
        return documents;
    }
}
