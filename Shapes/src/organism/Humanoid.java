package organism;

public class Humanoid extends Human implements Machine{

    @Override
    public void eat() {
        System.out.println("Humanoid is eating.");
    }

    @Override
    public void move() {
        System.out.println("Humanoid is moving.");
    }

    @Override
    public void reproduce() {
        System.out.println("Humanoid is reproducing.");
    }

    @Override
    public void breathe() {
        System.out.println("Humanoid is breathing.");
    }

    @Override
    public void sleep() {
        System.out.println("Humanoid is sleeping.");
    }

    @Override
    public void start() {
        System.out.println("Humanoid is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Humanoid is stopping.");
    }

    @Override
    public void laugh() {
        super.laugh();
        System.out.println("Humanoid is laughing.");
    }
}
