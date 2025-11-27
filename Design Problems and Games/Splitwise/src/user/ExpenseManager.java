package user;

import expense.Expense;

import java.util.*;

public class ExpenseManager {
    private List<Group> groups = new ArrayList<>();

    public void addGroup(Group group) {
        groups.add(group);
    }
    public void addExpense(User from, User to, double amount) {
        from.addTransaction(to, amount);
        to.addTransaction(from, -amount);
    }

//    public void addExpense(Group group, Expense expense) {
//        group.addExpense(expense);
//        Map<User, Double> splits = expense.calculateSplits();
//
//        for (Map.Entry<User, Double> entry : splits.entrySet()) {
//            User user = entry.getKey();
//            double userShare = entry.getValue();
//
//            if (!user.equals(expense.getPaidBy())) {
//                user.addBalance(expense.getPaidBy(), -userShare);
//                expense.getPaidBy().addBalance(user, userShare);
//            }
//        }
//    }

    public void showBalances(Group group) {
        for (User user : group.getMembers()) {
            user.showBalances();
        }
    }
}
