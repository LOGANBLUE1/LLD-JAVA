package designProblemsAndGames.notificationService.observer;

import designProblemsAndGames.notificationService.service.NotificationService;

public class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.subscribe(this);
    }

    public Logger(NotificationObservable observable) {
        notificationObservable.subscribe(this);
        this.notificationObservable = observable;
    }

    public void update() {
        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
    }
}