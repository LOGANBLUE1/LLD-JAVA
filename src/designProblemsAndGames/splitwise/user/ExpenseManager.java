package designProblemsAndGames.splitwise.user;

import designProblemsAndGames.splitwise.expense.Expense;
import designProblemsAndGames.splitwise.expense.Split;
import designProblemsAndGames.splitwise.expense.SplitStrategy;
import designProblemsAndGames.splitwise.expense.SplitStrategyFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Mediator for the users. Every debt is created and settled here; users never touch each
 * other, and the only way to move money is through a group.
 *
 * The balances themselves live on the Group, one flat map per group. This class owns the
 * rules - who may be a participant, how an expense becomes debts - and delegates the
 * splitting itself to a SplitStrategy per SplitType.
 */
public class ExpenseManager {

    private final Map<String, Group> groups = new LinkedHashMap<>();

    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    /**
     * The one way money enters the system: split the expense, then post each participant's
     * share as a debt to whoever paid.
     */
    public void addExpense(Group group, Expense expense) {
        requireRegistered(group);
        for (User participant : expense.getParticipants()) {
            if (!group.hasMember(participant)) {
                throw new IllegalArgumentException(
                        participant.getName() + " is not a member of " + group.getName());
            }
        }

        SplitStrategy strategy = SplitStrategyFactory.forType(expense.getSplitType());
        for (Split split : strategy.calculateSplits(expense)) {
            // Whoever paid does not owe themselves their own share.
            if (split.getUser().equals(expense.getPaidBy())) {
                continue;
            }
            group.recordDebt(expense.getPaidBy(), split.getUser(), split.getAmount());
        }
        group.addExpense(expense);
    }

    /**
     * A repayment: {@code from} hands {@code to} cash, cancelling that much of what
     * {@code from} owes within this group.
     */
    public void settleUp(Group group, User from, User to, double amount) {
        requireRegistered(group);
        if (amount <= 0) {
            throw new IllegalArgumentException("A settlement must be a positive amount");
        }
        group.recordDebt(from, to, amount);
        System.out.println(from.getName() + " settled ₹" + amount
                + " with " + to.getName() + " in " + group.getName());
    }

    public void showBalances(Group group) {
        requireRegistered(group);
        System.out.println("--- Balances for " + group.getName() + " ---");
        List<Debt> debts = group.outstandingDebts();
        if (debts.isEmpty()) {
            System.out.println("Everyone is settled up");
            return;
        }
        for (Debt debt : debts) {
            System.out.println(debt.debtor().getName() + " owes ₹" + round(debt.amount())
                    + " to " + debt.creditor().getName());
        }
    }

    private void requireRegistered(Group group) {
        if (!groups.containsKey(group.getId())) {
            throw new IllegalArgumentException("Unknown group: " + group.getId());
        }
    }

    private double round(double amount) {
        return Math.round(amount * 100) / 100.0;
    }
}