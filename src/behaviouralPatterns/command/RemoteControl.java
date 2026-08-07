package behaviouralPatterns.command;

import behaviouralPatterns.command.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<String, Command> buttons = new HashMap<>();

    public void register(String button, Command command) {
        buttons.put(button, command);
    }

    public void press(String button) {
        buttons.get(button).execute();
    }
}