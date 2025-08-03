package flyweight;

import lombok.Setter;

public class Ball {
    public String color;
    public String imageUrl;
    public int cordX;
    public int cordY;
    public int radius;

    public Ball(String color, String imageUrl) {
        this.color = color;
        this.imageUrl = imageUrl;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }
    public void setCordY(int cordY) {
        this.cordY = cordY;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color='" + color + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", cordX=" + cordX +
                ", cordY=" + cordY +
                ", radius=" + radius +
                '}';
    }
}
