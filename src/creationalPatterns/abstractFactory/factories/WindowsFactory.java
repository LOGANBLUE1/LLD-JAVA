package creationalPatterns.abstractFactory.factories;

import creationalPatterns.abstractFactory.buttons.Button;
import creationalPatterns.abstractFactory.buttons.WindowsButton;
import creationalPatterns.abstractFactory.checkboxes.Checkbox;
import creationalPatterns.abstractFactory.checkboxes.WindowsCheckbox;

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