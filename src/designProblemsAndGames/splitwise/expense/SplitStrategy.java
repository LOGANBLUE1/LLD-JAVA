package designProblemsAndGames.splitwise.expense;

import java.util.List;

/**
 * Turns an expense into the per-participant shares it breaks down into.
 * One implementation per SplitType, picked by SplitStrategyFactory.
 *
 * Implementations must return splits that sum exactly to the expense amount,
 * so the mediator can post them to balances without losing paise to rounding.
 */
public interface SplitStrategy {
    List<Split> calculateSplits(Expense expense);
}