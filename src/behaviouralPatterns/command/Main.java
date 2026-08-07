package behaviouralPatterns.command;

import behaviouralPatterns.command.commands.Command;
import behaviouralPatterns.command.commands.TurnOffCommand;
import behaviouralPatterns.command.commands.TurnOnCommand;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand = new TurnOnCommand(light);
        Command offCommand = new TurnOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.register("A", onCommand);
        remote.register("B", offCommand);

        remote.press("A");

        remote.press("B");
    }
}