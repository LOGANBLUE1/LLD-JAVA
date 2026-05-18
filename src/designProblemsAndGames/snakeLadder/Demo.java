package designProblemsAndGames.snakeLadder;
import java.util.*;
public class Demo {
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to snake-ladder, if you want to enter snake and ladder input press y/Y");
        String input = sc.next();
        Game game = new Game();
        if ((Objects.equals(input.toUpperCase(), "Y")))
            game.takeSnakeLadderInput();
        else
            game.takeDefaultSnakeLadderInput();

        game.takePlayerInput();
        game.playGame();
    }
}