package designProblemsAndGames.googleDocs;

import designProblemsAndGames.googleDocs.element.DocumentElement;

import java.util.ArrayList;
import java.util.List;

public class Document {
    List<DocumentElement> elements;
    public Document() {
        this.elements = new ArrayList<>();
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void render() {
        for (DocumentElement element : elements) {
            element.render();
        }
    }
}
