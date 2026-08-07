package structuralPatterns.bridge;

import structuralPatterns.bridge.device.Device;
import structuralPatterns.bridge.device.Radio;
import structuralPatterns.bridge.device.Tv;
import structuralPatterns.bridge.remote.AdvancedRemote;
import structuralPatterns.bridge.remote.BasicRemote;

public class Demo {
    void main() {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}