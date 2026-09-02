package designProblemsAndGames.splitwise.expense;

import designProblemsAndGames.splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy {

    @Override
    public List<Split> calculateSplits(Expense expense) {
        List<User> participants = expense.getParticipants();
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("An expense needs at least one participant");
        }

        // Split in paise, not rupees: 1000/3 is not representable as a double, so dividing in
        // rupees loses a paisa and the balances stop summing to zero. The remainder goes one
        // paisa at a time to the first few participants, exactly like Splitwise does it.
        long totalPaise = Math.round(expense.getAmount() * 100);
        long basePaise = totalPaise / participants.size();
        long remainder = totalPaise % participants.size();

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            long sharePaise = basePaise + (i < remainder ? 1 : 0);
            splits.add(new Split(sharePaise / 100.0, participants.get(i)));
        }
        return splits;
    }
}