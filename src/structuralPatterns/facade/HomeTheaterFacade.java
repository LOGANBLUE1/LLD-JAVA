package structuralPatterns.facade;

class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem sound;
    private DVDPlayer dvd;
    private Lights lights;

    public HomeTheaterFacade() {
        projector = new Projector();
        sound = new SoundSystem();
        dvd = new DVDPlayer();
        lights = new Lights();
    }

    public void watchMovie(String movie) {
        lights.dim();
        projector.on();
        sound.on();
        sound.setVolume(50);
        dvd.on();
        dvd.play(movie);
    }
}