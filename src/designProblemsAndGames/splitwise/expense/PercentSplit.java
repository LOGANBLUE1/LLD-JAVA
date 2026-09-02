package designProblemsAndGames.splitwise.expense;

import designProblemsAndGames.splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class PercentSplit implements SplitStrategy {

    private static final double EPSILON = 0.01;

    @Override
    public List<Split> calculateSplits(Expense expense) {
        List<User> participants = expense.getParticipants();
        List<Double> percentages = expense.getPercentages();

        if (percentages == null || participants == null || percentages.size() != participants.size()) {
            throw new IllegalArgumentException(
                    "A PERCENT expense needs one percentage per participant");
        }

        double totalPercent = percentages.stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercent - 100.0) > EPSILON) {
            throw new IllegalArgumentException("Percentages must add up to 100, got " + totalPercent);
        }

        // Same paise arithmetic as EqualSplit. Percentages rarely divide the total cleanly
        // (33.33% of 1000), so the last participant absorbs whatever rounding is left over
        // and the splits still sum to the expense exactly.
        long totalPaise = Math.round(expense.getAmount() * 100);
        long allocatedPaise = 0;

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            long sharePaise;
            if (i == participants.size() - 1) {
                sharePaise = totalPaise - allocatedPaise;
            } else {
                sharePaise = Math.round(totalPaise * percentages.get(i) / 100.0);
                allocatedPaise += sharePaise;
            }
            splits.add(new Split(sharePaise / 100.0, participants.get(i)));
        }
        return splits;
    }
}