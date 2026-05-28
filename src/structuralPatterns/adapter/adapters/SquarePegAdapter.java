package structuralPatterns.adapter.adapters;

import structuralPatterns.adapter.round.RoundPeg;
import structuralPatterns.adapter.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return peg.getWidth()/Math.sqrt(2);
    }
}