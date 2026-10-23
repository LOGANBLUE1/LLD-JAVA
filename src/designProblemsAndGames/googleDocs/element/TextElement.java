package designProblemsAndGames.googleDocs.element;

public class TextElement extends DocumentElement {
    String text;
    public TextElement(String text) {
        this.text = text;
    }
    @Override
    public void render() {
        System.out.println("Text is rendered");
    }
}
