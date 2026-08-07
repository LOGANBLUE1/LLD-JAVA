package behaviouralPatterns.chainOfResponsibility.example2;

public abstract class Handler {
    private Handler next;
    protected boolean isTail;

    /**
     * Builds chains of middleware objects.
     */
    public static Handler link(Handler first, Handler... chain) {
        Handler head = first;
        for (Handler nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public abstract void dispense(int amount);

    /**
     * Runs dispense on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected void dispenseNext(int amount) {
        if (next == null) {
            return;
        }
        next.dispense(amount);
    }

    /**
     * Subclasses implement this to report whether they (plus the rest of the
     * chain) can fully break down the given amount.
     */
    public abstract boolean validate(int amount);

    /**
     * Runs validate on the next object in chain. If we're at the end of the
     * chain, the amount is only satisfiable if nothing is left to dispense.
     */
    protected boolean validateNext(int amount) {
        if (amount == 0) {
            return true;
        }
        if (next == null) {
            return false;
        }
        return next.validate(amount);
    }
}