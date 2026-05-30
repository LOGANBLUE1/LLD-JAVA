package structuralPatterns.facade;

class Projector {
    void on() {
        System.out.println("Projector ON");
    }
}

class SoundSystem {
    void on() {
        System.out.println("Sound ON");
    }

    void setVolume(int volume) {
        System.out.println("Volume: " + volume);
    }
}

class DVDPlayer {
    void on() {
        System.out.println("DVD ON");
    }

    void play(String movie) {
        System.out.println("Playing " + movie);
    }
}

class Lights {
    void dim() {
        System.out.println("Lights dimmed");
    }
}