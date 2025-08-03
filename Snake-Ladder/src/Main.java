import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to snake-ladder, if you want to enter snake and ladder input press y/Y");
        String input = sc.next();
        Game game = new Game();
        if((Objects.equals(input.toUpperCase(), "Y")))
            game.takeSnakeLadderInput();

        game.takePlayerInput();
        game.playGame();
    }
}