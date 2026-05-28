package creationalPatterns.abstractFactory.factories;

import creationalPatterns.abstractFactory.buttons.Button;
import creationalPatterns.abstractFactory.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
