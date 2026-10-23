package designProblemsAndGames.notificationService;

import designProblemsAndGames.notificationService.observer.IObserver;
import designProblemsAndGames.notificationService.observer.NotificationObservable;
import designProblemsAndGames.notificationService.service.NotificationService;
import designProblemsAndGames.notificationService.strategy.INotificationStrategy;

import java.util.ArrayList;
import java.util.List;

class NotificationEngine implements IObserver {
    private NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.subscribe(this);
    }

    public NotificationEngine(NotificationObservable observable) {
        this.notificationObservable = observable;
    }

    public void addNotificationStrategy(INotificationStrategy ns) {
        this.notificationStrategies.add(ns);
    }

    // Can have RemoveNotificationStrategy as well.

    public void update() {
        String notificationContent = notificationObservable.getNotificationContent();
        for (INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationContent);
        }
    }
}
