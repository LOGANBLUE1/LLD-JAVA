package organism;

public class Human extends Mammal {

    @Override
    public void eat() {
        System.out.println("organism.Human is eating.");
    }

    @Override
    public void move() {
        System.out.println("organism.Human is moving.");
    }

    @Override
    public void reproduce() {
        System.out.println("organism.Human is reproducing.");
    }

    @Override
    public void breathe() {
        System.out.println("organism.Human is breathing.");
    }

    @Override
    public void sleep() {
        System.out.println("organism.Human is sleeping.");
    }

    public void laugh() {
        System.out.println("organism.Human is laughing.");
    }
}
