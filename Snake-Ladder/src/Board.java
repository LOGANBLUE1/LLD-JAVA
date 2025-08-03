import java.util.HashMap;
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
        if (snake.start > snake.end)
            this.snakes.put(snake.start, snake.end);
    }


    public void addLadder(Ladder ladder) {
        if (ladder.start < ladder.end)
            this.ladders.put(ladder.start, ladder.end);
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

    public Board getDefaultSnakes() {
        this.addSnake(new Snake(62, 5));
        this.addSnake(new Snake(33, 6));
        this.addSnake(new Snake(49, 9));
        this.addSnake(new Snake(88, 16));
        this.addSnake(new Snake(41, 20));
        this.addSnake(new Snake(56, 53));
        this.addSnake(new Snake(98, 64));
        this.addSnake(new Snake(93, 73));
        this.addSnake(new Snake(95, 75));
        return this;
    }

    public Board getDefaultLadders() {
        this.addLadder(new Ladder(2, 37));
        this.addLadder(new Ladder(27, 46));
        this.addLadder(new Ladder(10, 32));
        this.addLadder(new Ladder(51, 68));
        this.addLadder(new Ladder(61, 79));
        this.addLadder(new Ladder(65, 84));
        this.addLadder(new Ladder(71, 91));
        this.addLadder(new Ladder(81, 100));
        return this;
    }
}
