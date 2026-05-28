import structuralPatterns.proxy.Image;
import structuralPatterns.proxy.ProxyImage;


    void main() {
        Image image = new ProxyImage("test_image.jpg");
        image.display();
        image.display();
    }