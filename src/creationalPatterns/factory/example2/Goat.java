package creationalPatterns.factory.example2;

public class Goat extends AnimalOptions {
    @Override
    public void milk() {
        System.out.println("Milking the goat");
    }
}
