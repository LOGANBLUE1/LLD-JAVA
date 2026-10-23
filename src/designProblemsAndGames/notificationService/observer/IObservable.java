package designProblemsAndGames.notificationService.observer;
 interface IObservable {
    void subscribe(IObserver observer);
    void unsubscribe(IObserver observer);
    void notifyy();
}
