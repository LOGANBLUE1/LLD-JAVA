package publisher;

import listener.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    // event -->  list of subscribers
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String event, EventListener listener) {
        List<EventListener> users = listeners.get(event);
        users.add(listener);
    }

    public void unsubscribe(String event, EventListener listener) {
        List<EventListener> users = listeners.get(event);
        users.remove(listener);
    }

    public void notify(String event, File file) {
        List<EventListener> users = listeners.get(event);
        for (EventListener listener : users) {
            listener.update(event, file);
        }
    }
}