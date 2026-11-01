package designProblemsAndGames.notificationService.observer;

import designProblemsAndGames.notificationService.NotificationService;

public class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.subscribe(this);
    }

    public Logger(NotificationObservable topic) {
        this.notificationObservable = topic;
        notificationObservable.subscribe(this);
    }

    public void update() {
        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
    }
}