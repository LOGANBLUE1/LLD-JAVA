import structuralPatterns.Proxy.Image;
import structuralPatterns.Proxy.ProxyImage;


    void main() {
        Image image = new ProxyImage("test_image.jpg");
        image.display();
        image.display();
    }