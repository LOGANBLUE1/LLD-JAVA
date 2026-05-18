package creationalPatterns.Factory;

import creationalPatterns.Factory.shapes.Circle;
import creationalPatterns.Factory.shapes.Rectangle;
import creationalPatterns.Factory.shapes.Shape;
import creationalPatterns.Factory.shapes.ShapeType;

public class Factory {
    public Shape getShape(ShapeType shapeType) {
        if (shapeType.equals(ShapeType.CIRCLE)) {
            return new Circle();
        } else if (shapeType.equals(ShapeType.RECTANGLE)) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
