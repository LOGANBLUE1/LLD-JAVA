package behaviouralPatterns.strategy;

import behaviouralPatterns.strategy.fly.IFliable;
import behaviouralPatterns.strategy.talk.ITalkable;
import behaviouralPatterns.strategy.walk.IWalkable;

public class Robot implements IRobot {
    private IFliable f;
    private ITalkable t;
    private IWalkable w;

    public Robot(IWalkable w, IFliable f, ITalkable t) {
        this.w = w;
        this.f = f;
        this.t = t;
    }

    @Override
    public void walk() {
        w.walk();
    }

    @Override
    public void talk() {
        t.talk();
    }

    @Override
    public void fly() {
        f.fly();
    }
}
