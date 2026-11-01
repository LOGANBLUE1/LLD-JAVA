package behaviouralPatterns.observer.publisher;

import behaviouralPatterns.observer.listener.IEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Channel implements IPublisher{
    // event -->  list of subscribers
    Map<String, List<IEventListener>> subscribers = new HashMap<>();

    public Channel(String... operations) {
        for (String operation : operations) {
            this.subscribers.put(operation, new ArrayList<>());
        }
    }

    public void postContent() {

    }

    @Override
    public void subscribe(String event, IEventListener listener) {
        subscribers.get(event).add(listener);
    }

    @Override
    public void unsubscribe(String event, IEventListener listener) {
        subscribers.get(event).remove(listener);
    }

    @Override
    public void notify(String event, File file) {
        for (IEventListener subscribers : subscribers.get(event)) {
            subscribers.update(event, file);
        }
    }
}