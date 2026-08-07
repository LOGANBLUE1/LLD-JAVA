package behaviouralPatterns.mediator;

public interface ChatMediator {
    void sendMessage(String message, User sender);
}