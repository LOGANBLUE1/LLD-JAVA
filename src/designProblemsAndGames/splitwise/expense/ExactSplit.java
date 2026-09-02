package designProblemsAndGames.splitwise.expense;

import designProblemsAndGames.splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class ExactSplit implements SplitStrategy {

    private static final double EPSILON = 0.01;

    @Override
    public List<Split> calculateSplits(Expense expense) {
        List<User> participants = expense.getParticipants();
        List<Double> exactAmounts = expense.getExactAmounts();

        if (exactAmounts == null || participants == null || exactAmounts.size() != participants.size()) {
            throw new IllegalArgumentException(
                    "An EXACT expense needs one amount per participant");
        }

        double sum = exactAmounts.stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(sum - expense.getAmount()) > EPSILON) {
            throw new IllegalArgumentException(
                    "Exact amounts sum to " + sum + " but the expense is " + expense.getAmount());
        }

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            splits.add(new Split(exactAmounts.get(i), participants.get(i)));
        }
        return splits;
    }
}