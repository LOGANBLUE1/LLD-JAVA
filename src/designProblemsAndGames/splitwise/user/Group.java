package designProblemsAndGames.splitwise.user;

import designProblemsAndGames.splitwise.expense.Expense;
//import lombok.Getter;

import java.util.*;


public class Group {
    private String id;
    private String name;

    public List<User> getMembers() {
        return members;
    }

    private final List<User> members;
    private final List<Expense> expenses;

    public Group(String id, String name, List<User> members) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
