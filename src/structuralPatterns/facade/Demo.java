package structuralPatterns.facade;

// Very simple design-pattern
// just handles the complexity of multiple subsystems and provides a simple interface to the client
public class Demo {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();

        theater.watchMovie("Inception");
    }
}