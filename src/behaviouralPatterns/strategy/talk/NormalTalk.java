package behaviouralPatterns.strategy.talk;

public class NormalTalk implements ITalkable {
    @Override
    public void talk() {
        System.out.println("Normal talk");
    }
}
