package designProblemsAndGames.notificationService.service;

import designProblemsAndGames.notificationService.decorator.INotification;
import designProblemsAndGames.notificationService.observer.NotificationObservable;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private NotificationObservable observable;
    private static NotificationService instance = null;
    private List<INotification> notifications = new ArrayList<>();

    private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    // Expose the observable so observers can attach.
    public NotificationObservable getObservable() {
        return observable;
    }

    // Creates a new Notification and notifies observers.
    public void sendNotification(INotification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
}