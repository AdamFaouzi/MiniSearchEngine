# MiniSearchEngine

A comand line search engine that indexes and searches .txt documents

# How to compile

Make sure you are located in the 'MiniSearchEngine' folder, then run:
javac *.java
java MiniSearchEngine <path-to-documents-folder>

# Example:
javac *.java
java MiniSearchEngine test_documents

# Usage,
Once running, you will see a menu:

1. Build Index — loads and indexes all `.txt` files from the provided folder
2. Search — enter a word or multiple words to search across documents
3. Statistics — shows number of documents and unique terms in the index
4. Exit — exits the program

# Note: You must build the index (option 1) before searching.