package designProblemsAndGames.splitwise.expense;

import designProblemsAndGames.splitwise.user.User;

import java.util.List;

/**
 * What was spent, by whom, on whose behalf, and how it should be divided.
 *
 * Built through the factory methods so a split type can never arrive without the numbers it
 * needs - there is no way to hand PERCENT an expense with no percentages. It is immutable for
 * the same reason: the strategy validates once at construction, and nothing can invalidate it
 * afterwards.
 */
public class Expense {
    private final String id;
    private final User paidBy;
    private final double amount;
    private final List<User> participants;
    private final SplitType splitType;
    private final List<Double> percentages;
    private final List<Double> exactAmounts;

    private Expense(String id, SplitType splitType, User paidBy, double amount,
                    List<User> participants, List<Double> percentages, List<Double> exactAmounts) {
        this.id = id;
        this.splitType = splitType;
        this.paidBy = paidBy;
        this.amount = amount;
        this.participants = List.copyOf(participants);
        this.percentages = percentages == null ? null : List.copyOf(percentages);
        this.exactAmounts = exactAmounts == null ? null : List.copyOf(exactAmounts);
    }

    public static Expense equal(String id, User paidBy, double amount, List<User> participants) {
        return new Expense(id, SplitType.EQUAL, paidBy, amount, participants, null, null);
    }

    public static Expense exact(String id, User paidBy, double amount,
                                List<User> participants, List<Double> exactAmounts) {
        return new Expense(id, SplitType.EXACT, paidBy, amount, participants, null, exactAmounts);
    }

    public static Expense percent(String id, User paidBy, double amount,
                                  List<User> participants, List<Double> percentages) {
        return new Expense(id, SplitType.PERCENT, paidBy, amount, participants, percentages, null);
    }

    public String getId() {
        return id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Double> getPercentages() {
        return percentages;
    }

    public List<Double> getExactAmounts() {
        return exactAmounts;
    }

    @Override
    public String toString() {
        return paidBy.getName() + " paid ₹" + amount + " for "
                + participants + " (" + splitType + ")";
    }
}