package flyweight;

import java.util.AbstractMap;
import java.util.Map;

public class FlyWeightDemo {
    public static final String[] colors = {"red", "green", "blue", "yellow", "black"};
    public static final Map<String, String> urlMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("red", "https://example.com/red.png"),
            new AbstractMap.SimpleEntry<>("green", "https://example.com/green.png"),
            new AbstractMap.SimpleEntry<>("blue", "https://example.com/blue.png"),
            new AbstractMap.SimpleEntry<>("yellow", "https://example.com/yellow.png"),
            new AbstractMap.SimpleEntry<>("black", "https://example.com/black.png")
    );
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            String color = colors[(int) (Math.random() * colors.length)];
            String url = urlMap.get(color);
            Ball ball = BallFactory.getBall(color, url);
            ball.setCordX((int) (Math.random() * 100));
            ball.setCordY((int) (Math.random() * 100));
            ball.setRadius(75);
            System.out.println(ball.hashCode());
        }
    }
}
