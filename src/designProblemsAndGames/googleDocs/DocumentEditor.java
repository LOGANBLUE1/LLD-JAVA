package designProblemsAndGames.googleDocs;

import designProblemsAndGames.googleDocs.element.ImageElement;
import designProblemsAndGames.googleDocs.element.TextElement;
import designProblemsAndGames.googleDocs.persistance.Persistance;

// Arguably this is breaking the single responsibility principle but if we move render to some other class
// it will break the least knowledge principle
public class DocumentEditor {
    public Document doc;
    public Persistance db;
    public String renderedDocument;
    public DocumentEditor(Document doc, Persistance db){
        this.doc = doc;
        this.db = db;
    }

    public void addText(String text){
        doc.addElement(new TextElement(text));
    }

    public void addImage(String image){
        doc.addElement(new ImageElement(image));
    }

    public void save(){
        db.save(doc);
    }

    public void render(){
//        if(renderedDocument.isBlank()){
            doc.render();
//        }

    }
}
