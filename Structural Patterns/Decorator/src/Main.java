// Component interface
interface Notifier {
    void send(String message);
}

// Concrete component
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

// Decorator base
class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete decorators
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) { super(notifier); }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier notifier) { super(notifier); }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack: " + message);
    }
}

class SkypeNotifier extends NotifierDecorator {
    public SkypeNotifier(Notifier notifier) { super(notifier); }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Skype: " + message);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Notifier notifier =
            new SMSNotifier(
                new SlackNotifier(
                    new SkypeNotifier(
                        new EmailNotifier())));
        notifier.send("Hello World!");
    }
}