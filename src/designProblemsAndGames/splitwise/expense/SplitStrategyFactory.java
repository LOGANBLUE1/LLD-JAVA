package designProblemsAndGames.splitwise.expense;

import java.util.Map;

/**
 * Maps a SplitType to the strategy that implements it, so ExpenseManager never
 * has to switch on the enum. Adding a new split type means adding a strategy and
 * one entry here - no change to the mediator.
 */
public final class SplitStrategyFactory {

    // The strategies hold no state, so one shared instance each is enough.
    private static final Map<SplitType, SplitStrategy> STRATEGIES = Map.of(
            SplitType.EQUAL, new EqualSplit(),
            SplitType.EXACT, new ExactSplit(),
            SplitType.PERCENT, new PercentSplit()
    );

    private SplitStrategyFactory() {
    }

    public static SplitStrategy forType(SplitType splitType) {
        SplitStrategy strategy = STRATEGIES.get(splitType);
        if (strategy == null) {
            throw new IllegalArgumentException("No split strategy registered for " + splitType);
        }
        return strategy;
    }
}