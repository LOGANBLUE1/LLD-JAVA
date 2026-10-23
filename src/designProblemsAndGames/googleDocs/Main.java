package designProblemsAndGames.googleDocs;

import designProblemsAndGames.googleDocs.persistance.Persistance;
import designProblemsAndGames.googleDocs.persistance.SaveToFile;

public class Main {
    public static void main(String[] args) {
        System.out.println("Google Docs");
        Document document = new Document();
        Persistance db = new SaveToFile();
        DocumentEditor editor = new DocumentEditor(document, db);
        editor.addText("Hello World");
        editor.addImage("image.png");
        editor.save();
        editor.render();
    }
}
