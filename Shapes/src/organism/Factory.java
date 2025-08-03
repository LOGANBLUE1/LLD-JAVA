package organism;

public class Factory {
    Organism get_adapter(String type) {
        if (type.equalsIgnoreCase("humanoid")) {
            return new Humanoid();
        } else if (type.equalsIgnoreCase("machine")) {
            return new Humanoid();
        } else if (type.equalsIgnoreCase("animal")) {
            return new Humanoid();
        } else if (type.equalsIgnoreCase("mammal")) {
            return new Humanoid();
        } else if (type.equalsIgnoreCase("human")) {
            return new Humanoid();
        } else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
