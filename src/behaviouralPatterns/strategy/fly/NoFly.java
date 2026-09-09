package behaviouralPatterns.strategy.fly;

public class NoFly implements IFliable {
    @Override
    public void fly() {
        System.out.println("No fly");
    }
}
