package structuralPatterns.decorator.addables;

import structuralPatterns.decorator.Notifier;
import structuralPatterns.decorator.NotifierDecorator;

public class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack: " + message);
    }
}
