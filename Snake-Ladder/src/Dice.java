import java.util.Random;

public class Dice {
    int sides;
    int count;
    private Random rand = new Random();

    public Dice(int sides, int count){
        this.sides = sides;
        this.count = count;
    }
    public Dice(int count){
        this(6, count);
    }
    public Dice(){
        this(1);
    }

    public int getRand(){
        return rand.nextInt(this.sides)+1;
    }
    public int getNumber(){
        if(this.count == 1 && this.sides == 6){
            return getFinalNumber();
        }
        int ans = 0;
        for(int i=0;i<this.count;i++){
            ans += getRand();
        }
        return ans;
    }
    private int getFinalNumber(){
        int ans = 0;
        for(int i=0;i<3;i++){
            int currRoll = this.getRand();
            ans += currRoll;
            if(currRoll!=6) {
                break;
            }
        }
        return ans == 18 ? 0 : ans;
    }
}