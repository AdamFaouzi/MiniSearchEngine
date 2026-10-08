import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Document{
    private int docId;
    private String name;
    private String path;
    private String content;

    public Document(int docId,String name, String path){//all arguments constructor
        this.docId = docId;
        this.name = name;
        this.path = path;
    }
    //getters
    public int getDocId(){return docId;}
    public String getName(){return name;}
    public String getPath(){return path;}
    public String getContent() {
    if (content == null) {
        try {
            content = Files.readString(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Could not read file: " + name);
            return "";
        }
    }
    return content;
}
}