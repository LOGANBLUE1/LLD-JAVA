package behaviouralPatterns.observer.publisher;

import behaviouralPatterns.observer.listener.IEventListener;

import java.io.File;

public interface IPublisher {
    void notify(String event, File file);
    void subscribe(String event, IEventListener listener);
    void unsubscribe(String event, IEventListener listener);
}
