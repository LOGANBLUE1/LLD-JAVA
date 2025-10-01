import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.ShapeType;

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
