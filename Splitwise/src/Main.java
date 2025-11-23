import expense.Expense;
import expense.Split;
import expense.SplitType;
import user.ExpenseManager;
import user.User;
import user.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void addTransaction(User from, User to, double amount) {
        from.addTransaction(to, amount);
        to.addTransaction(from, -amount);
    }
    public static void main(String[] args) {
        User u1 = new User("1", "Alice", "daf", "123");
        User u2 = new User("2", "Bob", "daf", "456");
        User u3 = new User("3", "Charlie", "daf", "789");
        User u4 = new User("4", "David", "daf", "101");
        Group g1 = new Group("g1", "Trip", Arrays.asList(u1, u2, u3, u4));

        ExpenseManager manager = new ExpenseManager();

        manager.addExpense(u1, u2, 100);//100 paid to u2 by u1
        manager.addGroup(g1);

        Expense e1 = new Expense("1", SplitType.EQUAL, u1, 1000, Arrays.asList(u1, u2, u3));
        manager.showBalances(g1);

//        u1 1250 2 u2 u3 EXACT 370 880
//        em.spendExact(List.of(u2, u3), List.of(370.0, 880.0), u1);

//        u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
//        em.spendPercent(List.of(u2, u3, u4), List.of(20.0, 20.0, 20.0), u1, 1200.0);
    }
}