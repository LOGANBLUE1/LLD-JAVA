package behaviouralPatterns.strategy;

import behaviouralPatterns.strategy.fly.NormalFly;
import behaviouralPatterns.strategy.talk.NormalTalk;
import behaviouralPatterns.strategy.walk.NormalWalk;

public class Main {
    void main(){
        Robot robot = new Robot(new NormalWalk(), new NormalFly(), new NormalTalk());
        robot.talk();
        robot.fly();
        robot.walk();
    }
}
