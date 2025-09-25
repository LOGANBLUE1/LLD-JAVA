import shapes.Shape;
import shapes.ShapeType;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Shape shape1 = factory.getShape(ShapeType.CIRCLE);
        Shape shape2 = factory.getShape(ShapeType.RECTANGLE);
        Shape shape3 = shape1.clone();
        System.out.println("Shape1 equals Shape3: " + shape1.equals(shape3));
    }
}