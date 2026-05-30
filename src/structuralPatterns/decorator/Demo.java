// Component interface
package structuralPatterns.decorator;


import structuralPatterns.decorator.addables.SMSNotifier;
import structuralPatterns.decorator.addables.SlackNotifier;

// Level - 2/3 , Important - 2/3
public class Demo {
    public static void main(String[] args) {
        Notifier notifier =
            new SMSNotifier(
                new SlackNotifier(
                        new EmailNotifier()));
        notifier.send("Hello World!");
    }
}