import java.util.*;

public class Game {
    Scanner sc = new Scanner(System.in);
    Board board;
    Dice dice;
    ArrayList<Player> players;


    public Game(){
        this.board = new Board().getDefaultSnakes().getDefaultLadders();
        this.dice = new Dice(1);
        players = new ArrayList<>();
    }

    private void addPlayer(Player player){
        this.players.add(player);
    }

    public void playGame(){
        int playersPlaying = players.size();
        while(playersPlaying > 1){
            for (Player player : players) {
                if(!player.finished) {
                    String name = player.name;
                    int initial = player.position;
                    int number = dice.getNumber();
                    int newpos = board.movePiece(initial, number);
                    System.out.println(name + " rolled a " + number + " and moved from " + initial + " to " + newpos);
                    player.position = newpos;
                    if (newpos == 100) {
                        System.out.println(name + " wins the game");
                        player.finished = true;
                        playersPlaying--;
                    }
                }
            }
        }
    }

    public void takeSnakeLadderInput(){
        System.out.println("Enter number of snakes followed by values: ");
        int snakeCnt = sc.nextInt();
        for (int i = 0; i < snakeCnt; i++) {
            int head = sc.nextInt();
            int tail = sc.nextInt();
            if (head <= tail) {
                System.out.println("Wrong snake found...");
            }
            this.board.addSnake(new Snake(head, tail));
        }

        System.out.println("Enter number of ladders followed by values: ");
        int ladderCnt = sc.nextInt();
        for (int i = 0; i < ladderCnt; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (end <= start) {
                System.out.println("Wrong ladder found...");
            }
            this.board.addLadder(new Ladder(start, end));
        }
    }

    public void takePlayerInput(){
        System.out.println("Enter number of players followed by names: ");
        int playerCnt = sc.nextInt();
        for (int i = 0; i < playerCnt; i++) {
            String word = sc.next();
            this.addPlayer(new Player(word));
        }
    }
}
