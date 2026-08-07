package behaviouralPatterns.chainOfResponsibility.example2;

public class NoteDispenser extends Handler{
    int denomination;
    int numRemaining;
    public NoteDispenser(int denomination, int numRemaining){
        this.denomination = denomination;
        this.numRemaining = numRemaining;
    }

    @Override
    public void dispense(int amount) {
        if(amount == 0)
            return;
        if(amount < denomination){
            System.out.println("Skipping " + this.denomination + " notes");
            this.dispenseNext(amount);
            return;
        }
        int reqNum = amount/this.denomination;
        if(reqNum > numRemaining){
            reqNum = numRemaining;
        }
        amount -= reqNum * this.denomination;
        System.out.println("Dispensing " + reqNum + " Notes of " + this.denomination + "₹");
        this.dispenseNext(amount);
    }

    @Override
    public boolean validate(int amount) {
        if (amount == 0) {
            return true;
        }
        if (amount < denomination) {
            return this.validateNext(amount);
        }
        int reqNum = amount / this.denomination;
        if (reqNum > numRemaining) {
            reqNum = numRemaining;
        }
        amount -= reqNum * this.denomination;
        return this.validateNext(amount);
    }
}
