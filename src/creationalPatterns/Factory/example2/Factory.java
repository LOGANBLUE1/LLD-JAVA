package creationalPatterns.Factory.example2;

public class Factory {
    public static Animal getAnimal(int nipples) {
        return switch (nipples) {
            case 2 -> new Goat();
            case 4 -> new Cow();
            default -> throw new IllegalArgumentException("Not a valid number of nipples");
        };
    }
}
