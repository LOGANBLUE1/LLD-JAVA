package designProblemsAndGames.notificationService.observer;

import designProblemsAndGames.notificationService.decorator.INotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationObservable implements IObservable {
    private List<IObserver> listeners = new ArrayList<>();
    private INotification currentNotification = null;

    public void subscribe(IObserver obs) {
        listeners.add(obs);
    }

    public void unsubscribe(IObserver obs) {
        listeners.remove(obs);
    }

    @Override
    public void notifyy() {
        for (IObserver obs : listeners) {
            obs.update();
        }
    }

    public void setNotification(INotification notification) {
        this.currentNotification = notification;
        this.notifyy();
    }

    public INotification getNotification() {
        return currentNotification;
    }

    public String getNotificationContent() {
        return currentNotification.getContent();
    }
}