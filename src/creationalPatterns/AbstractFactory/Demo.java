package creationalPatterns.AbstractFactory;

import creationalPatterns.AbstractFactory.factories.GUIFactory;
import creationalPatterns.AbstractFactory.factories.MacOSFactory;
import creationalPatterns.AbstractFactory.factories.WindowsFactory;

public class Demo {
    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        return new Application(factory);
    }

    void main(String[] args) {
        Application app = configureApplication();
        app.print();
    }
}