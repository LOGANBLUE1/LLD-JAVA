package behaviouralPatterns.strategy.walk;

public class NoWalk implements IWalkable {
    @Override
    public void walk() {
        System.out.println("No walk");
    }
}
