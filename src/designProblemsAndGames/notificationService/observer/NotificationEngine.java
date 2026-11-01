package designProblemsAndGames.notificationService.observer;

import designProblemsAndGames.notificationService.NotificationService;
import designProblemsAndGames.notificationService.strategy.INotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class NotificationEngine implements IObserver {
    private NotificationObservable topic;
    private List<INotificationStrategy> notificationStrategy = new ArrayList<>();

    public NotificationEngine() {
        this.topic = NotificationService.getInstance().getObservable();
        topic.subscribe(this);
    }

    public NotificationEngine(NotificationObservable topic) {
        this.topic = topic;
    }

    public void addNotificationStrategy(INotificationStrategy ns) {
        this.notificationStrategy.add(ns);
    }

    // Can have RemoveNotificationStrategy as well.

    public void update() {
        String notificationContent = topic.getNotificationContent();
        for (INotificationStrategy strategy : notificationStrategy) {
            strategy.sendNotification(notificationContent);
        }
    }
}
