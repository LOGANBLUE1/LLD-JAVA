// Component interface
package structuralPatterns.Decorator;

// Usage
public class Demo {
    void main() {
        Notifier notifier =
            new SMSNotifier(
                new SlackNotifier(
                    new SkypeNotifier(
                        new EmailNotifier())));
        notifier.send("Hello World!");
    }
}