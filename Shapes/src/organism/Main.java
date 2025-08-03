package organism;

public class Main {
    public static void main(String[] args) {
        Organism humanoid = new Humanoid();
        Human humanoid2 = new Humanoid();
        Machine humanoid3 = new Humanoid();
        Animal humanoid4 = new Humanoid();
        Mammal humanoid5 = new Humanoid();
        Humanoid humanoid6 = new Humanoid();
        Factory factory = new Factory();
//        humanoid.breathe();
//        humanoid2.reproduce();
//        humanoid6.laugh();
        Organism obj = factory.get_adapter("humanoid");
        obj.sleep();
    }
}