package designProblemsAndGames.notificationService;

import designProblemsAndGames.notificationService.decorator.INotification;
import designProblemsAndGames.notificationService.decorator.SignatureDecorator;
import designProblemsAndGames.notificationService.decorator.SimpleNotification;
import designProblemsAndGames.notificationService.decorator.TimestampDecorator;
import designProblemsAndGames.notificationService.observer.Logger;
import designProblemsAndGames.notificationService.service.NotificationService;
import designProblemsAndGames.notificationService.strategy.EmailStrategy;
import designProblemsAndGames.notificationService.strategy.PopUpStrategy;
import designProblemsAndGames.notificationService.strategy.SMSStrategy;

public class Main {
    public static void main(String []args){
        // Create NotificationService.
        NotificationService notificationService = NotificationService.getInstance();

        // Create Logger Observer
        Logger logger = new Logger();

        // Create NotificationEngine observers.
        NotificationEngine notificationEngine = new NotificationEngine();

        notificationEngine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());

        INotification notification = new SimpleNotification("Your order has been shipped!");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Care");

        notificationService.sendNotification(notification);
    }
}
