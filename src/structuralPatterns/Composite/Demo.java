package structuralPatterns.Composite;

import structuralPatterns.Composite.editor.ImageEditor;
import structuralPatterns.Composite.shapes.Circle;
import structuralPatterns.Composite.shapes.CompoundShape;
import structuralPatterns.Composite.shapes.Rectangle;
import structuralPatterns.Composite.shapes.Dot;

import java.awt.*;

public class Demo {
    void main() {
            ImageEditor editor = new ImageEditor();

            editor.loadShapes(
                    new Circle(10, 10, 10, Color.BLUE),

                    new CompoundShape(
                            new Circle(110, 110, 50, Color.RED),
                            new Dot(160, 160, Color.RED)
                    ),

                    new CompoundShape(
                            new Rectangle(250, 250, 100, 100, Color.GREEN),
                            new Dot(240, 240, Color.GREEN),
                            new Dot(240, 360, Color.GREEN),
                            new Dot(360, 360, Color.GREEN),
                            new Dot(360, 240, Color.GREEN)
                    )
            );
    }
}