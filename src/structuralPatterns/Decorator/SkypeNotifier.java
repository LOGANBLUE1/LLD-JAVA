package structuralPatterns.Decorator;

class SkypeNotifier extends NotifierDecorator {
    public SkypeNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Skype: " + message);
    }
}
