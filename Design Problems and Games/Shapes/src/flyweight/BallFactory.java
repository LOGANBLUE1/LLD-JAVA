package flyweight;

import java.util.HashMap;

public class BallFactory {
    public static final HashMap ballMap = new HashMap();
    public static Ball getBall(String color, String url) {
        String key = color + url;

        Ball ball = (Ball) ballMap.get(key);
        if (ball == null) {
            ball = new Ball(color, url);
            ballMap.put(key, ball);
            System.out.println("Creating new ball of color: " + color);
        }
        return ball;
    }
}
