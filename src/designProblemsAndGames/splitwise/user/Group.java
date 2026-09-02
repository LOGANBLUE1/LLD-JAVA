package designProblemsAndGames.splitwise.user;

import designProblemsAndGames.splitwise.expense.Expense;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A group and the balances between its members.
 *
 * Balances are one flat map keyed by an unordered UserPair: a positive amount means
 * pair.second() owes pair.first(). One row per pair of people, so a repayment nets against
 * the original loan by arithmetic rather than by remembering to update a mirror entry.
 *
 * Both mutators are package-private - only ExpenseManager may write here, so a debt cannot
 * be created without going through the split that justifies it.
 */
public class Group {

    // Below this, a balance is rounding noise from a percentage split, not a real debt.
    private static final double SETTLED_THRESHOLD = 0.01;

    private final String id;
    private final String name;
    private final List<User> members;
    private final List<Expense> expenses;
    // LinkedHashMap so balances list in the order the debts first appeared, not hash order.
    private final Map<UserPair, Double> balances = new LinkedHashMap<>();

    public Group(String id, String name, List<User> members) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>(members);
        this.expenses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public boolean hasMember(User user) {
        return members.contains(user);
    }

    void addExpense(Expense expense) {
        expenses.add(expense);
    }

    /** Records that {@code borrower} now owes {@code lender} a further {@code amount}. */
    void recordDebt(User lender, User borrower, double amount) {
        UserPair pair = UserPair.of(lender, borrower);
        // Store against the pair's canonical direction, flipping the sign if this debt runs
        // the other way. Merging then nets loans and repayments into the single row.
        double signed = pair.first().equals(lender) ? amount : -amount;
        balances.merge(pair, signed, Double::sum);
    }

    /** Every unsettled debt, each stated once in the direction that makes it positive. */
    public List<Debt> outstandingDebts() {
        List<Debt> debts = new ArrayList<>();
        for (Map.Entry<UserPair, Double> entry : balances.entrySet()) {
            UserPair pair = entry.getKey();
            double amount = entry.getValue();
            if (amount > SETTLED_THRESHOLD) {
                debts.add(new Debt(pair.second(), pair.first(), amount));
            } else if (amount < -SETTLED_THRESHOLD) {
                debts.add(new Debt(pair.first(), pair.second(), -amount));
            }
        }
        return debts;
    }
}