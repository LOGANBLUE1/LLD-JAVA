package designProblemsAndGames.googleDocs.persistance;

import designProblemsAndGames.googleDocs.Document;

public class SaveToFile extends Persistance{
    @Override
    public void save(Document document) {
        System.out.println("Saving document to file");
    }
}
