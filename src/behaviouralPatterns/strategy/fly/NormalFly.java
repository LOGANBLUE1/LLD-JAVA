package behaviouralPatterns.strategy.fly;

public class NormalFly implements IFliable{
    @Override
    public void fly() {
        System.out.println("Normal fly");
    }
}
