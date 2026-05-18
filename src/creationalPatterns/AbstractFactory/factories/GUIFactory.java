package creationalPatterns.AbstractFactory.factories;

import creationalPatterns.AbstractFactory.buttons.Button;
import creationalPatterns.AbstractFactory.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
