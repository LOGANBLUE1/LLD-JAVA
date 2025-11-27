import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Board {
    int size;
    private Map<Integer, Integer> ladders;
    private Map<Integer, Integer> snakes;

    public Board(int size) {
        this.size = size;
    }

    public Board() {
        this.size = 100;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void addSnake(Snake snake) {
        if(ladders.containsKey(snake.tail()) && snakes.get(snake.tail()).equals(snake.head())) {
            System.out.println("Snake and ladder cannot be at same position");
            return;
        }
        if (snake.head() > snake.tail())
            this.snakes.put(snake.head(), snake.tail());
    }


    public void addLadder(Ladder ladder) {
        if(snakes.containsKey(ladder.top()) && snakes.get(ladder.top()).equals(ladder.bottom())) {
            System.out.println("Snake and ladder cannot be at same position");
            return;
        }
        if (ladder.bottom() < ladder.top())
            this.ladders.put(ladder.bottom(), ladder.top());
    }

    public int movePiece(int currentPos, int number){
        int nextPos = currentPos + number;
        if(nextPos > 100)
            return currentPos;
        while(this.ladders.containsKey(nextPos) || this.snakes.containsKey(nextPos)){
            if(this.ladders.containsKey(nextPos))
                nextPos = this.ladders.get(nextPos);
            else
                nextPos = this.snakes.get(nextPos);
        }
        return nextPos;
    }

    public void getDefaultSnakes() {
        List<Snake> defaultSnakes = List.of(
                new Snake(62, 5),
                new Snake(33, 6),
                new Snake(49, 9),
                new Snake(88, 16),
                new Snake(41, 20),
                new Snake(56, 53),
                new Snake(98, 64),
                new Snake(93, 73),
                new Snake(95, 75)
        );
        defaultSnakes.forEach(this::addSnake);
    }

    public void getDefaultLadders() {
        List<Ladder> defaultLadders = List.of(
                new Ladder(2, 37),
                new Ladder(27, 46),
                new Ladder(10, 32),
                new Ladder(51, 68),
                new Ladder(61, 79),
                new Ladder(65, 84),
                new Ladder(71, 91),
                new Ladder(81, 100)
        );
        defaultLadders.forEach(this::addLadder);
    }
}
