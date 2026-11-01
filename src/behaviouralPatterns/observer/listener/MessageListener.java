package behaviouralPatterns.observer.listener;

import java.io.File;

public class MessageListener implements IEventListener {
    private String log;

    public MessageListener(String fileName) {
        this.log = fileName;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}