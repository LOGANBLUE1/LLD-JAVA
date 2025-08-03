package organism;

public class Apple extends AngeoSperm {
    @Override
    public void reproduce() {
        System.out.println("organism.Human is living.");
    }

    @Override
    public void breathe() {
        System.out.println("organism.Human is breathing.");
    }

    @Override
    public void sleep() {
        System.out.println("organism.Human is sleeping.");
    }

    @Override
    public void photosynthesis() {
        System.out.println("organism.Apple is performing photosynthesis.");
    }
}
