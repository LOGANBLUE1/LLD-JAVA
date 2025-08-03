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




class Snake {
    int start, end;
    Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Ladder {
    int start, end;
    Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }
}