package behaviouralPatterns.strategy.walk;

public class NormalWalk implements IWalkable {
    @Override
    public void walk() {
        System.out.println("Normal Walk");
    }
}
