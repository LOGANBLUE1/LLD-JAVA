interface Image {
    void display();
}
class RealImage implements Image{
    private final String filename;

    public RealImage(String filename){
        this.filename = filename;
        loadFromDisk();
    }
    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }
    @Override
    public void display(){
        System.out.println("Displaying Real Image");
    }
}
class ProxyImage implements Image{
    private RealImage realImage;
    private final String filename;

    public ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display(){
        if(realImage == null){
            System.out.println("Initialized");
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        image.display();
        image.display();
    }
}