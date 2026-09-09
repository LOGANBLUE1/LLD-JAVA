package behaviouralPatterns.strategy.talk;

public class NoTalk implements ITalkable {
    @Override
    public void talk() {
        System.out.println("No talk");
    }
}
