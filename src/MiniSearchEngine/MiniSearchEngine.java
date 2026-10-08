public class MiniSearchEngine {
    public static void main(String[] args) {
        if (args.length == 0) {//make sure that the user provided a folder path as an argument
            System.out.println("Please provide folder path.");
            return;
        }
        TerminalInterface.runMenu(args[0]); //run the terminal interface with the provided folder path
    }


    
}