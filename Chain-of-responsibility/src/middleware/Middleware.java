package middleware;

public abstract class Middleware {
    private Middleware next;

    /**
     * Builds chains of middleware objects.
     */
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware curr = first;
        for (Middleware nextInChain: chain) {
            curr.next = nextInChain;
            curr = nextInChain;
        }
        return first;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public abstract boolean check(String email, String password);

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected boolean checkNext(String email, String password) {
        System.out.println("Checking next middleware...");
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}