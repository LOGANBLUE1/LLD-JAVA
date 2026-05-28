package creationalPatterns.factory;

import creationalPatterns.factory.shapes.Circle;
import creationalPatterns.factory.shapes.Rectangle;
import creationalPatterns.factory.shapes.Shape;
import creationalPatterns.factory.shapes.ShapeType;

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
