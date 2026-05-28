package creationalPatterns.abstractFactory.factories;

import creationalPatterns.abstractFactory.buttons.Button;
import creationalPatterns.abstractFactory.buttons.MacOSButton;
import creationalPatterns.abstractFactory.checkboxes.Checkbox;
import creationalPatterns.abstractFactory.checkboxes.MacOSCheckbox;

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