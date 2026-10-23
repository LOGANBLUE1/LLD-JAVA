package behaviouralPatterns.observer.publisher;

import behaviouralPatterns.observer.listener.IEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager implements IPublisher{
    // event -->  list of subscribers
    Map<String, List<IEventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    @Override
    public void subscribe(String event, IEventListener listener) {
        listeners.get(event).add(listener);
    }

    @Override
    public void unsubscribe(String event, IEventListener listener) {
        listeners.get(event).remove(listener);
    }

    @Override
    public void notify(String event, File file) {
        for (IEventListener subscribers : listeners.get(event)) {
            subscribers.update(event, file);
        }
    }
}