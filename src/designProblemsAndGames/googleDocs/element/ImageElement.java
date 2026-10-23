package designProblemsAndGames.googleDocs.element;

public class ImageElement extends DocumentElement {
    String image;
    public ImageElement(String image) {
        this.image = image;
    }
    @Override
    public void render() {
        System.out.println("Image is rendered");
    }
}
