package behaviouralPatterns.observer;

import behaviouralPatterns.observer.editor.Editor;
import behaviouralPatterns.observer.listener.EmailNotificationListener;
import behaviouralPatterns.observer.listener.LogOpenListener;

public class Main {
    void main() {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}