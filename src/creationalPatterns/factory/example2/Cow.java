package creationalPatterns.factory.example2;

public class Cow extends AnimalOptions {
    @Override
    public void milk() {
        System.out.println("Milking the cow");
    }

}
