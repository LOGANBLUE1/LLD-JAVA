package creationalPatterns.AbstractFactory.factories;

import creationalPatterns.AbstractFactory.buttons.Button;
import creationalPatterns.AbstractFactory.buttons.WindowsButton;
import creationalPatterns.AbstractFactory.checkboxes.Checkbox;
import creationalPatterns.AbstractFactory.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}