package designProblemsAndGames.splitwise;

import designProblemsAndGames.splitwise.expense.Expense;
import designProblemsAndGames.splitwise.user.ExpenseManager;
import designProblemsAndGames.splitwise.user.Group;
import designProblemsAndGames.splitwise.user.User;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User alice = new User("1", "Alice", "alice@mail.com", "123");
        User bob = new User("2", "Bob", "bob@mail.com", "456");
        User charlie = new User("3", "Charlie", "charlie@mail.com", "789");
        User david = new User("4", "David", "david@mail.com", "101");

        Group trip = new Group("g1", "Trip", Arrays.asList(alice, bob, charlie, david));

        ExpenseManager manager = new ExpenseManager();
        manager.addGroup(trip);

        // Alice paid 1000 for herself, Bob and Charlie: 333.34 / 333.33 / 333.33.
        manager.addExpense(trip, Expense.equal("e1", alice, 1000, List.of(alice, bob, charlie)));

        // Alice paid 1250, Bob owes exactly 370 and Charlie exactly 880.
        manager.addExpense(trip, Expense.exact("e2", alice, 1250,
                List.of(bob, charlie), List.of(370.0, 880.0)));

        // David paid 1200 split 40/20/20/20.
        manager.addExpense(trip, Expense.percent("e3", david, 1200,
                List.of(alice, bob, charlie, david), List.of(40.0, 20.0, 20.0, 20.0)));

        manager.showBalances(trip);

        // Bob pays Alice back - this nets against what he already owes her rather than
        // being recorded as a separate debt in the other direction.
        System.out.println();
        manager.settleUp(trip, bob, alice, 500);
        System.out.println();

        manager.showBalances(trip);
    }
}