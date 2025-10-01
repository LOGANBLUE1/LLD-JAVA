public class Player {
    String name;
    int position;
    public boolean finished;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
        this.finished = false;
    }
    public Player(String name){
        this(name,0);
    }
}


record Snake(int head, int tail) {}

record Ladder(int bottom, int top) {}