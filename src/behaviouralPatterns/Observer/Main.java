package behaviouralPatterns.Observer;

import behaviouralPatterns.Observer.editor.Editor;
import behaviouralPatterns.Observer.listener.EmailNotificationListener;
import behaviouralPatterns.Observer.listener.LogOpenListener;

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