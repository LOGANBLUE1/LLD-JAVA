package creationalPatterns.AbstractFactory;

import creationalPatterns.AbstractFactory.buttons.Button;
import creationalPatterns.AbstractFactory.checkboxes.Checkbox;
import creationalPatterns.AbstractFactory.factories.GUIFactory;

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void print() {
        button.print();
        checkbox.print();
    }
}