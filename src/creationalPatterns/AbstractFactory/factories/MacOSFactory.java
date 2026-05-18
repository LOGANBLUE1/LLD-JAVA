package creationalPatterns.AbstractFactory.factories;

import creationalPatterns.AbstractFactory.buttons.Button;
import creationalPatterns.AbstractFactory.buttons.MacOSButton;
import creationalPatterns.AbstractFactory.checkboxes.Checkbox;
import creationalPatterns.AbstractFactory.checkboxes.MacOSCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}